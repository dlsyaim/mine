package com.mine.alpha.model;

public class Material {
    private Integer id;

    private String name;

    private Double amount;

    private Double price;

    public Material(Integer id, String name, Double amount, Double price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Material() {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}