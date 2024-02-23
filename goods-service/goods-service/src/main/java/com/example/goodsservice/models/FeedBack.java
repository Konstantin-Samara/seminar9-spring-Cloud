package com.example.goodsservice.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long idGoods;

    @Column(nullable = false)
    private String item;

    @Column(nullable = false)
    private String date = "created : "
            +LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    @Override
    public String toString(){
        return this.item+" "+this.date;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }


    public long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(long idGoods) {
        this.idGoods = idGoods;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
