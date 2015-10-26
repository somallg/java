package com.somallg.jax.rs.json.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by somallg on 12/7/14.
 */

@XmlRootElement
public class Person {

    private String name;

    private int age;

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
}
