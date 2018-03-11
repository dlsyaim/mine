package com.mine.alpha.model;

import java.util.List;

public class Enterprise {
    private Integer id;

    private String username;

    private String email;

    private String password;

    private String passSalt;

    private String fullname;

    private String usci;

    private String bslic;

    private List<Role> roles;

    public Enterprise(Integer id, String username, String email, String password, String passSalt, String fullname, String usci, String bslic) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.passSalt = passSalt;
        this.fullname = fullname;
        this.usci = usci;
        this.bslic = bslic;
    }

    public Enterprise() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getUsci() {
        return usci;
    }

    public void setUsci(String usci) {
        this.usci = usci == null ? null : usci.trim();
    }

    public String getBslic() {
        return bslic;
    }

    public void setBslic(String bslic) {
        this.bslic = bslic == null ? null : bslic.trim();
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}