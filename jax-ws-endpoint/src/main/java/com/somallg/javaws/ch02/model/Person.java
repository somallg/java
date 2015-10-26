package com.somallg.javaws.ch02.model;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by somallg on 5/15/14.
 */

@XmlType
public class Person {
    // fields
    private String name;
    private int age;
    private String gender;

    // constructors
    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // properties: name, age, gender

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
