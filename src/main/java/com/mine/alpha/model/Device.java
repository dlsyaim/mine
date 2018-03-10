package com.mine.alpha.model;

public class Device {
    private Integer id;

    private Integer name;

    private Integer amount;

    private Double price;

    private String status;

    public Device(Integer id, Integer name, Integer amount, Double price, String status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.status = status;
    }

    public Device() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}