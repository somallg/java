package com.somallg.javaws.ch02.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by somallg on 5/15/14.
 */

@XmlRootElement
public class Skier {
    // fields
    private Person person;
    private String national_team;
    @SuppressWarnings("rawtypes")
    private Collection major_achievements;

    // constructors
    public Skier() {
    }

    public Skier(Person person, String national_team, @SuppressWarnings("rawtypes") Collection major_achievements) {
        this.person = person;
        this.national_team = national_team;
        this.major_achievements = major_achievements;
    }

    // properties
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNationalTeam() {
        return national_team;
    }

    public void setNationalTeam(String national_team) {
        this.national_team = national_team;
    }

    @SuppressWarnings("rawtypes")
    public Collection getMajorAchievements() {
        return major_achievements;
    }

    public void setMajorAchievements(@SuppressWarnings("rawtypes") Collection major_achievements) {
        this.major_achievements = major_achievements;
    }
}
