package com.jnt.newdbs.Models;

public class DataModel {

    private Character ch1;
    private Character ch2;
    private int distance;
    private boolean active;

    public DataModel() {
        ch1 = null;
        ch2 = null;
        distance = 0;
        active = false;
    }

    public DataModel(Character char1, Character char2, int distance, boolean active) {
        this.ch1 = char1;
        this.ch2 = char2;
        this.distance = distance;
        this.active = active;
    }

    public DataModel(boolean active) {
        this.active = active;
    }

    public Character getCh1() {
        return ch1;
    }

    public void setCh1(Character ch1) {
        this.ch1 = ch1;
    }

    public Character getCh2() {
        return ch2;
    }

    public void setCh2(Character ch2) {
        this.ch2 = ch2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
