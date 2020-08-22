package com.foreverredremilia.jpademo.service;

import com.foreverredremilia.jpademo.entity.dto.QueryDto;
import com.foreverredremilia.jpademo.entity.vo.CharacterPage;
import com.foreverredremilia.jpademo.entity.vo.CharacterVo;

import java.util.List;

public interface CharacterService {


    List<CharacterVo> getCharaVo(QueryDto queryDto);

    List<CharacterVo> getCharaVo2(QueryDto queryDto);

    CharacterPage getCharaPage(QueryDto queryDto);

}
