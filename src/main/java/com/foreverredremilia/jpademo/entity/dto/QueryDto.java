package com.foreverredremilia.jpademo.entity.dto;

import javax.validation.constraints.*;

public class QueryDto {

    private String characterRace; //角色种族
    @NotBlank(message = "地点名称为必填值！")
    private String residenceName; //地点名称
    private String gameName; //游戏名称
    @DecimalMin(message = "page必须大于0", value = "1")
    private Integer page;
    @DecimalMin(message = "size必须大于等于20", value = "20")
    private Integer size;

    public String getCharacterRace() {
        return characterRace;
    }

    public String getResidenceName() {
        return residenceName;
    }

    public String getGameName() {
        return gameName;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }
}
