package com.mine.alpha.model;

import java.util.List;

public class User {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String passSalt;

    private String email;

    private Integer enterpriseId;

    private List<Role> roles;

    public User(Integer id, String name, String username, String password, String passSalt, String email, Integer enterpriseId) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.passSalt = passSalt;
        this.email = email;
        this.enterpriseId = enterpriseId;
    }

    public User() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPassSalt() {
        return passSalt;
    }

    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt == null ? null : passSalt.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}