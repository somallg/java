package com.somallg.javaws.ch1.teamservice.client;

import com.somallg.javaws.ch1.teamservice.domain.Team;
import com.somallg.javaws.ch1.teamservice.ws.TeamWS;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TeamClient {

    private static String URL_STRING = "http://localhost:8888/teams?wsdl";

    private static String targetNamespace = "http://impl.ws.teamservice.ch1/";

    private static String serviceName = "TeamsImplService";

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL(URL_STRING);

        QName qName = new QName(targetNamespace, serviceName);

        Service service = Service.create(url, qName);

        TeamWS servicePort = service.getPort(TeamWS.class);
        List<Team> teams = servicePort.getTeams();

        System.out.println(teams);
    }
}
