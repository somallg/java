package com.somallg.javaws.ch1.teamservice.util;

import com.somallg.javaws.ch1.teamservice.domain.Player;
import com.somallg.javaws.ch1.teamservice.domain.Team;

import java.util.*;

/**
 * Created by somallg on 5/12/14.
 */
public class TeamsUtility {
    private Map<String, Team> team_map;

    public TeamsUtility() {
        team_map = new HashMap<String, Team>();
    }

    public Team getTeam(String name) {
        return team_map.get(name);
    }

    public List<Team> getTeams() {
        List<Team> list = new ArrayList<Team>();
        Set<String> keys = team_map.keySet();
        for (String key : keys)
            list.add(team_map.get(key));

        return list;
    }

    public void make_test_teams() {
        List<Team> teams = new ArrayList<Team>();
        Player chico = new Player("Leonard", "Chico");
        Player groucho = new Player("Julius", "Groucho");
        Player harpo = new Player("Adolph", "Harpo");
        List<Player> mb = new ArrayList<Player>();
        mb.add(chico);
        mb.add(groucho);
        mb.add(harpo);
        Team marx = new Team("Marx", mb);
        teams.add(marx);

        store_teams(teams);
    }

    private void store_teams(List<Team> teams) {
        for (Team team : teams)
            team_map.put(team.getName(), team);
    }
}
