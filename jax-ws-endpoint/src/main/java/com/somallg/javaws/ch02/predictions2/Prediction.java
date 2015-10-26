package com.somallg.javaws.ch02.predictions2;

import java.io.Serializable;

/**
 * Created by somallg on 10/5/14.
 */
public class Prediction implements Serializable, Comparable<Prediction> {
    /**
     *
     */
    private static final long serialVersionUID = 1792622680839087800L;
    private String who; // person
    private String what; // his/her prediction
    private int id; // identifier used as lookup key

    public Prediction() {
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Prediction other) {
        return this.id - other.id;
    }
}
