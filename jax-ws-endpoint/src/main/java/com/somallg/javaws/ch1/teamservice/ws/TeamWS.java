package com.somallg.javaws.ch1.teamservice.ws;

import com.somallg.javaws.ch1.teamservice.domain.Team;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by somallg on 11/18/2014.
 */

@WebService
public interface TeamWS {
    Team getTeam(String name);

    List<Team> getTeams();
}
