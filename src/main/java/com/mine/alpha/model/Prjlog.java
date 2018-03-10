package com.mine.alpha.model;

import java.util.Date;

public class Prjlog {
    private Integer id;

    private Integer prjId;

    private Integer dvcId;

    private String status;

    private Date time;

    private String content;

    public Prjlog(Integer id, Integer prjId, Integer dvcId, String status, Date time, String content) {
        this.id = id;
        this.prjId = prjId;
        this.dvcId = dvcId;
        this.status = status;
        this.time = time;
        this.content = content;
    }

    public Prjlog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrjId() {
        return prjId;
    }

    public void setPrjId(Integer prjId) {
        this.prjId = prjId;
    }

    public Integer getDvcId() {
        return dvcId;
    }

    public void setDvcId(Integer dvcId) {
        this.dvcId = dvcId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}