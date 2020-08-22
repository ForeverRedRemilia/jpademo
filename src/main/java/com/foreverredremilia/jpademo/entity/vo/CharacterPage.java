package com.foreverredremilia.jpademo.entity.vo;

import java.util.List;

public class CharacterPage {

    private Long count;
    private List<CharacterVo> characterVoList;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<CharacterVo> getCharacterVoList() {
        return characterVoList;
    }

    public void setCharacterVoList(List<CharacterVo> characterVoList) {
        this.characterVoList = characterVoList;
    }
}
