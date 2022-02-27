package com.jnt.newdbs.Models;

public class PositionModel {
    private String data;
    private boolean active;

    public PositionModel() {
        active = false;
        data = null;
    }

    public PositionModel(String data, boolean active) {
        this.data = data;
        this.active = active;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
