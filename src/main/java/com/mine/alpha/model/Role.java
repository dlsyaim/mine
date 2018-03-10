package com.mine.alpha.model;

import java.util.List;

public class Role {
    private Integer id;

    private String name;

    private List<Permission> permissions;

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}