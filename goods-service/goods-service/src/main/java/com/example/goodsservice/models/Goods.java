package com.example.goodsservice.models;

import jakarta.persistence.*;

@Entity
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description = "no description";

    @Column(nullable = false)
    private String name = "no name";

    @Column(nullable = false)
    private Double price = 0.00;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "id:"+this.id+" name:"+this.name+" price:"+this.price+" description:"+this.description;
    }
}
