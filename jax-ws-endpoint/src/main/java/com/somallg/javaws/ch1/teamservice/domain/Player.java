package com.somallg.javaws.ch1.teamservice.domain;

/**
 * Created by somallg on 5/12/14.
 */
public class Player {
    private String name;
    private String nickname;

    public Player() {
    }

    public Player(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
