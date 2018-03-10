package com.mine.alpha.model;

public class Enterprise {
    private Integer id;

    private String email;

    private String password;

    private String passSalt;

    private String fullname;

    private String usci;

    private String bslic;

    public Enterprise(Integer id, String email, String password, String passSalt, String fullname, String usci, String bslic) {
        this.id = id;
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
}