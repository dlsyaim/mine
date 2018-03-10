package com.mine.alpha.model;

import java.util.Date;

public class Project {
    private Integer id;

    private String name;

    private Integer enterpriseId;

    private Date date;

    public Project(Integer id, String name, Integer enterpriseId, Date date) {
        this.id = id;
        this.name = name;
        this.enterpriseId = enterpriseId;
        this.date = date;
    }

    public Project() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}