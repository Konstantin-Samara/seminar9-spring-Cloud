package com.example.basketsservice.models;

import jakarta.persistence.*;

@Entity
public class BasketPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long idGoods;

    @Column(nullable = false)
    private long idBasket=0;

    @Column(nullable = false)
    private int count;

    @Column(nullable = true)
    private int numbInBasket;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(long idGoods) {
        this.idGoods = idGoods;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumbInBasket() {
        return numbInBasket;
    }

    public void setNumbInBasket(int numbInBasket) {
        this.numbInBasket = numbInBasket;
    }

    public long getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(long idBasket) {
        this.idBasket = idBasket;
    }

    @Override
    public String toString(){
        return "(id:"+this.id+") basket(id:"+this.idBasket+") goods(id:"+this.idGoods
                +") count:"+this.count+" N_in_basket:"+this.numbInBasket;
    }
}
