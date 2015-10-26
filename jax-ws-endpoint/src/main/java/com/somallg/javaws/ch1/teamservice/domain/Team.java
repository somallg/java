package com.somallg.javaws.ch1.teamservice.domain;

import java.util.List;

/**
 * Created by somallg on 5/12/14.
 */
public class Team {
    private List<Player> players;
    private String name;

    public Team() {
    }

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRosterCount() {
        return (players == null) ? 0 : players.size();
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                ", name='" + name + '\'' +
                '}';
    }
}
