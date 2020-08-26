package com.foreverredremilia.jpademo.service.impl;

import com.foreverredremilia.jpademo.entity.bean.CharaResidGameBean;
import com.foreverredremilia.jpademo.entity.bean.GameJoinBean;
import com.foreverredremilia.jpademo.entity.bean.ResidenceJoinBean;
import com.foreverredremilia.jpademo.entity.dto.QueryDto;
import com.foreverredremilia.jpademo.entity.vo.CharacterPage;
import com.foreverredremilia.jpademo.entity.vo.CharacterVo;
import com.foreverredremilia.jpademo.service.CharacterService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CharacterPage getCharaPage(QueryDto queryDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQry = criteriaBuilder.createQuery(Long.class);
        Root<CharaResidGameBean> root = countQry.from(CharaResidGameBean.class);
        //count必须用join声明连接方式
        root.join("residenceJoinBean", JoinType.INNER);
        root.join("gameJoinBean", JoinType.INNER);
        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        expressions.add(criteriaBuilder.equal(root.get("residenceJoinBean").get("residenceName"),
                queryDto.getResidenceName()));
        if (!StringUtils.isEmpty(queryDto.getGameName())) {
            expressions.add(criteriaBuilder.equal(root.get("gameJoinBean").get("gameName"),
                    queryDto.getGameName()));
        }
        if (!StringUtils.isEmpty(queryDto.getCharacterRace())) {
            expressions.add(criteriaBuilder.equal(root.get("characterRace"),
                    queryDto.getCharacterRace()));
        }
        countQry.select(criteriaBuilder.count(root)).where(predicate);
        //查询一共有多少条记录
        Long count = entityManager.createQuery(countQry).getSingleResult();
        CharacterPage characterPage = new CharacterPage();
        characterPage.setCount(count);
        CriteriaQuery<CharacterVo> criteriaQuery = criteriaBuilder.createQuery(CharacterVo.class);
        root = criteriaQuery.from(CharaResidGameBean.class);
        //由于root重新被声明给criteriaQuery作查询对象，所以需要重新join
        root.join("residenceJoinBean", JoinType.INNER);
        root.join("gameJoinBean", JoinType.INNER);
        criteriaQuery.select(criteriaBuilder.construct(CharacterVo.class,
                root.get("characterCode").alias("characterCode"),
                root.get("characterName").alias("characterName"),
                root.get("characterAge").alias("characterAge"),
                root.get("characterRace").alias("characterRace"),
                root.get("characterSkill").alias("characterSkill"),
                root.get("characterMusic").alias("characterMusic"),
                root.get("characterCreator").alias("characterCreator"),
                root.get("gameJoinBean").get("gameName").alias("gameName"),
                root.get("residenceJoinBean").get("residenceName").alias("residenceName")
        )).where(predicate);
        int start = (queryDto.getPage() - 1) * queryDto.getSize();
        List<CharacterVo> list = entityManager.createQuery(criteriaQuery)
                .setMaxResults(queryDto.getSize()).setFirstResult(start).getResultList();
        characterPage.setCharacterVoList(list);
        return characterPage;
    }

    @Override
    public List<CharacterVo> getCharaVo(QueryDto queryDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CharaResidGameBean> criteriaQuery = criteriaBuilder.
                createQuery(CharaResidGameBean.class);
        Root<CharaResidGameBean> root = criteriaQuery.from(CharaResidGameBean.class);
        //解决JPA的N+1问题
        root.fetch("residenceJoinBean", JoinType.INNER);
        root.fetch("gameJoinBean", JoinType.INNER);
        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        expressions.add(criteriaBuilder.equal(root.get("residenceJoinBean").get("residenceName"),
                queryDto.getResidenceName()));
        if (!StringUtils.isEmpty(queryDto.getGameName())) {
            expressions.add(criteriaBuilder.equal(root.get("gameJoinBean").get("gameName"),
                    queryDto.getGameName()));
        }
        if (!StringUtils.isEmpty(queryDto.getCharacterRace())) {
            expressions.add(criteriaBuilder.equal(root.get("characterRace"),
                    queryDto.getCharacterRace()));
        }
        criteriaQuery.select(root).where(predicate);
        int start = (queryDto.getPage() - 1) * queryDto.getSize();
        List<CharaResidGameBean> list = entityManager.createQuery(criteriaQuery)
                .setMaxResults(queryDto.getSize()).setFirstResult(start).getResultList();
        BeanCopier beanCopier = BeanCopier
                .create(CharaResidGameBean.class, CharacterVo.class, false);
        BeanCopier beanCopier1 = BeanCopier
                .create(ResidenceJoinBean.class, CharacterVo.class, false);
        BeanCopier beanCopier2 = BeanCopier
                .create(GameJoinBean.class, CharacterVo.class, false);
        List<CharacterVo> characterVos = new ArrayList<>();
        for (CharaResidGameBean bean : list) {
            CharacterVo characterVo = new CharacterVo();
            beanCopier.copy(bean, characterVo, null);
            beanCopier1.copy(bean.getResidenceJoinBean(), characterVo, null);
            beanCopier2.copy(bean.getGameJoinBean(), characterVo, null);
            characterVos.add(characterVo);
            System.out.println(characterVo);
        }
        return characterVos;
    }

    @Override
    public List<CharacterVo> getCharaVo2(QueryDto queryDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CharacterVo> criteriaQuery = criteriaBuilder.
                createQuery(CharacterVo.class);
        Root<CharaResidGameBean> root = criteriaQuery.from(CharaResidGameBean.class);
        //此种方式无需考虑JPA的N+1问题
        root.join("residenceJoinBean", JoinType.INNER);
        root.join("gameJoinBean", JoinType.INNER);
        Predicate predicate = criteriaBuilder.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();
        expressions.add(criteriaBuilder.equal(root.get("residenceJoinBean").get("residenceName"),
                queryDto.getResidenceName()));
        if (!StringUtils.isEmpty(queryDto.getGameName())) {
            expressions.add(criteriaBuilder.equal(root.get("gameJoinBean").get("gameName"),
                    queryDto.getGameName()));
        }
        if (!StringUtils.isEmpty(queryDto.getCharacterRace())) {
            expressions.add(criteriaBuilder.equal(root.get("characterRace"),
                    queryDto.getCharacterRace()));
        }
        criteriaQuery.select(criteriaBuilder.construct(CharacterVo.class,
                root.get("characterCode").alias("characterCode"),
                root.get("characterName").alias("characterName"),
                root.get("characterAge").alias("characterAge"),
                root.get("characterRace").alias("characterRace"),
                root.get("characterSkill").alias("characterSkill"),
                root.get("characterMusic").alias("characterMusic"),
                root.get("characterCreator").alias("characterCreator"),
                root.get("gameJoinBean").get("gameName").alias("gameName"),
                root.get("residenceJoinBean").get("residenceName").alias("residenceName")
        )).where(predicate);
        int start = (queryDto.getPage() - 1) * queryDto.getSize();
        return entityManager.createQuery(criteriaQuery)
                .setMaxResults(queryDto.getSize()).setFirstResult(start).getResultList();
    }



}
