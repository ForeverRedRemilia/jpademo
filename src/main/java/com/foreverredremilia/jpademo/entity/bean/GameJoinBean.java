package com.foreverredremilia.jpademo.entity.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "toho_game")
public class GameJoinBean {
    private String gameId; //游戏主键
    private String gameName; //游戏名称

    @Id
    @Column(name = "game_id")
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "game_name")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameJoinBean that = (GameJoinBean) o;
        return Objects.equals(gameId, that.gameId) &&
                Objects.equals(gameName, that.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, gameName);
    }
}
