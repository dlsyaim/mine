package com.mine.alpha.model;

public class Report {
    private Integer id;

    private Integer prjId;

    private Double miningAmount;

    private Double surroundingRockMass;

    private String grade;

    private Double dilution;

    private Double lossRate;

    private Double rawOre;

    private Double concentrateQuantity;

    private Double sewage;

    private String content;

    public Report(Integer id, Integer prjId, Double miningAmount, Double surroundingRockMass, String grade, Double dilution, Double lossRate, Double rawOre, Double concentrateQuantity, Double sewage, String content) {
        this.id = id;
        this.prjId = prjId;
        this.miningAmount = miningAmount;
        this.surroundingRockMass = surroundingRockMass;
        this.grade = grade;
        this.dilution = dilution;
        this.lossRate = lossRate;
        this.rawOre = rawOre;
        this.concentrateQuantity = concentrateQuantity;
        this.sewage = sewage;
        this.content = content;
    }

    public Report() {
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

    public Double getMiningAmount() {
        return miningAmount;
    }

    public void setMiningAmount(Double miningAmount) {
        this.miningAmount = miningAmount;
    }

    public Double getSurroundingRockMass() {
        return surroundingRockMass;
    }

    public void setSurroundingRockMass(Double surroundingRockMass) {
        this.surroundingRockMass = surroundingRockMass;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Double getDilution() {
        return dilution;
    }

    public void setDilution(Double dilution) {
        this.dilution = dilution;
    }

    public Double getLossRate() {
        return lossRate;
    }

    public void setLossRate(Double lossRate) {
        this.lossRate = lossRate;
    }

    public Double getRawOre() {
        return rawOre;
    }

    public void setRawOre(Double rawOre) {
        this.rawOre = rawOre;
    }

    public Double getConcentrateQuantity() {
        return concentrateQuantity;
    }

    public void setConcentrateQuantity(Double concentrateQuantity) {
        this.concentrateQuantity = concentrateQuantity;
    }

    public Double getSewage() {
        return sewage;
    }

    public void setSewage(Double sewage) {
        this.sewage = sewage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}