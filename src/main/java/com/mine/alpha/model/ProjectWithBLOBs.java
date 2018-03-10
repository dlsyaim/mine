package com.mine.alpha.model;

import java.util.Date;

public class ProjectWithBLOBs extends Project {
    private String location;

    private String drilledHoles;

    private String tunnel;

    private String statistic;

    public ProjectWithBLOBs(Integer id, String name, Integer enterpriseId, Date date, String location, String drilledHoles, String tunnel, String statistic) {
        super(id, name, enterpriseId, date);
        this.location = location;
        this.drilledHoles = drilledHoles;
        this.tunnel = tunnel;
        this.statistic = statistic;
    }

    public ProjectWithBLOBs() {
        super();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDrilledHoles() {
        return drilledHoles;
    }

    public void setDrilledHoles(String drilledHoles) {
        this.drilledHoles = drilledHoles == null ? null : drilledHoles.trim();
    }

    public String getTunnel() {
        return tunnel;
    }

    public void setTunnel(String tunnel) {
        this.tunnel = tunnel == null ? null : tunnel.trim();
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic == null ? null : statistic.trim();
    }
}