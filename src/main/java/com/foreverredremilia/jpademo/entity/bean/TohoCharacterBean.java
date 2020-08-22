package com.foreverredremilia.jpademo.entity.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "toho_character")
public class TohoCharacterBean {
    private String characterId; //角色主键
    private String characterCode; //角色编码
    private String characterName; //角色名称
    private Integer characterAge; //角色年龄
    private String characterRace; //角色种族
    private String characterSkill; //角色能力
    private String characterMusic; //角色背景曲
    private String characterCreator; //角色创建者
    private Date createTime; //角色创建日期
    private Integer status; //状态:0未启用1已启用2已删除
    private String residenceId; //隶属地主键
    private String gameId; //登场作品主键
    private byte[] characterAvatar; //角色头像

    @Id
    @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
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

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "residence_id")
    public String getResidenceId() {
        return residenceId;
    }

    public void setResidenceId(String residenceId) {
        this.residenceId = residenceId;
    }

    @Basic
    @Column(name = "game_id")
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "character_avatar")
    public byte[] getCharacterAvatar() {
        return characterAvatar;
    }

    public void setCharacterAvatar(byte[] characterAvatar) {
        this.characterAvatar = characterAvatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TohoCharacterBean that = (TohoCharacterBean) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(characterCode, that.characterCode) &&
                Objects.equals(characterName, that.characterName) &&
                Objects.equals(characterAge, that.characterAge) &&
                Objects.equals(characterRace, that.characterRace) &&
                Objects.equals(characterSkill, that.characterSkill) &&
                Objects.equals(characterMusic, that.characterMusic) &&
                Objects.equals(characterCreator, that.characterCreator) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(residenceId, that.residenceId) &&
                Objects.equals(gameId, that.gameId) &&
                Arrays.equals(characterAvatar, that.characterAvatar);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(characterId, characterCode, characterName, characterAge, characterRace, characterSkill, characterMusic, characterCreator, createTime, status, residenceId, gameId);
        result = 31 * result + Arrays.hashCode(characterAvatar);
        return result;
    }
}
