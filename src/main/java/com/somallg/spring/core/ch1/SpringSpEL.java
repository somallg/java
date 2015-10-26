package com.somallg.spring.core.ch1;

public class SpringSpEL {

    private String name;

    private int age;

    private boolean young;

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

    public boolean isYoung() {
        return young;
    }

    public void setYoung(boolean young) {
        this.young = young;
    }

    @Override
    public String toString() {
        return "SpringSpEL [name=" + name + ", age=" + age + ", young=" + young
                + "]";
    }

}
