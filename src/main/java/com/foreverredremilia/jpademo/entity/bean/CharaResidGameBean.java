package com.foreverredremilia.jpademo.entity.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "toho_character")
public class CharaResidGameBean {
    private String characterId; //角色主键
    private String characterCode; //角色编码
    private String characterName; //角色名称
    private Integer characterAge; //角色年龄
    private String characterRace; //角色种族
    private String characterSkill; //角色能力
    private String characterMusic; //角色背景曲
    private String characterCreator; //角色创建者
    private ResidenceJoinBean residenceJoinBean; //关联表B
    private GameJoinBean gameJoinBean; //关联表C

    @ManyToOne
    @JoinColumn(name = "game_id", insertable = false, updatable = false)
    public GameJoinBean getGameJoinBean() {
        return gameJoinBean;
    }

    public void setGameJoinBean(GameJoinBean gameJoinBean) {
        this.gameJoinBean = gameJoinBean;
    }

    @ManyToOne
    @JoinColumn(name = "residence_id", insertable = false, updatable = false)
    public ResidenceJoinBean getResidenceJoinBean() {
        return residenceJoinBean;
    }

    public void setResidenceJoinBean(ResidenceJoinBean residenceJoinBean) {
        this.residenceJoinBean = residenceJoinBean;
    }

    @Id
    @Column(name = "character_id")
    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    @Basic
    @Column(name = "character_code")
    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    @Basic
    @Column(name = "character_name")
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Basic
    @Column(name = "character_age")
    public Integer getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(Integer characterAge) {
        this.characterAge = characterAge;
    }

    @Basic
    @Column(name = "character_race")
    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    @Basic
    @Column(name = "character_skill")
    public String getCharacterSkill() {
        return characterSkill;
    }

    public void setCharacterSkill(String characterSkill) {
        this.characterSkill = characterSkill;
    }

    @Basic
    @Column(name = "character_music")
    public String getCharacterMusic() {
        return characterMusic;
    }

    public void setCharacterMusic(String characterMusic) {
        this.characterMusic = characterMusic;
    }

    @Basic
    @Column(name = "character_creator")
    public String getCharacterCreator() {
        return characterCreator;
    }

    public void setCharacterCreator(String characterCreator) {
        this.characterCreator = characterCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharaResidGameBean that = (CharaResidGameBean) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(characterCode, that.characterCode) &&
                Objects.equals(characterName, that.characterName) &&
                Objects.equals(characterAge, that.characterAge) &&
                Objects.equals(characterRace, that.characterRace) &&
                Objects.equals(characterSkill, that.characterSkill) &&
                Objects.equals(characterMusic, that.characterMusic) &&
                Objects.equals(characterCreator, that.characterCreator) &&
                Objects.equals(gameJoinBean, that.gameJoinBean) &&
                Objects.equals(residenceJoinBean, that.residenceJoinBean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, characterCode, characterName, characterAge, characterRace, characterSkill, characterMusic, characterCreator, gameJoinBean, residenceJoinBean);
    }
}
