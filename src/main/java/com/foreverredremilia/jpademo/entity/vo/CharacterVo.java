package com.foreverredremilia.jpademo.entity.vo;


public class CharacterVo {

    private String characterCode; //角色编码
    private String characterName; //角色名称
    private Integer characterAge; //角色年龄
    private String characterRace; //角色种族
    private String characterSkill; //角色能力
    private String characterMusic; //角色背景曲
    private String characterCreator; //角色创建者
    private String gameName; //游戏名称
    private String residenceName; //地点名称

    public CharacterVo(String characterCode, String characterName, Integer characterAge,
                       String characterRace, String characterSkill, String characterMusic,
                       String characterCreator, String gameName, String residenceName) {
        this.characterCode = characterCode;
        this.characterName = characterName;
        this.characterAge = characterAge;
        this.characterRace = characterRace;
        this.characterSkill = characterSkill;
        this.characterMusic = characterMusic;
        this.characterCreator = characterCreator;
        this.gameName = gameName;
        this.residenceName = residenceName;
    }

    public CharacterVo() {
    }

    public String getCharacterCode() {
        return characterCode;
    }

    public void setCharacterCode(String characterCode) {
        this.characterCode = characterCode;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(Integer characterAge) {
        this.characterAge = characterAge;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public String getCharacterSkill() {
        return characterSkill;
    }

    public void setCharacterSkill(String characterSkill) {
        this.characterSkill = characterSkill;
    }

    public String getCharacterMusic() {
        return characterMusic;
    }

    public void setCharacterMusic(String characterMusic) {
        this.characterMusic = characterMusic;
    }

    public String getCharacterCreator() {
        return characterCreator;
    }

    public void setCharacterCreator(String characterCreator) {
        this.characterCreator = characterCreator;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public void setResidenceName(String residenceName) {
        this.residenceName = residenceName;
    }
}
