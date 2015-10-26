package com.somallg.javaws.ch1.teamservice.ws.impl;

import com.somallg.javaws.ch1.teamservice.domain.Team;
import com.somallg.javaws.ch1.teamservice.util.TeamsUtility;
import com.somallg.javaws.ch1.teamservice.ws.TeamWS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by somallg on 5/12/14.
 */

@WebService(endpointInterface = "com.somallg.javaws.ch1.teamservice.ws.TeamWS")
public class TeamsImpl implements TeamWS {
    private TeamsUtility utils;

    public TeamsImpl() {
        utils = new TeamsUtility();
        utils.make_test_teams();
    }

    @WebMethod
    public Team getTeam(String name) {
        return utils.getTeam(name);
    }

    @WebMethod
    public List<Team> getTeams() {
        return utils.getTeams();
    }
}
