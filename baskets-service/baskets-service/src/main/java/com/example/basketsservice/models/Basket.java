package com.example.basketsservice.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Basket {

    public enum Status {ORDERED, WAITING}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private List<Long> listPositions = new ArrayList<>();

    @Column(nullable = true)
    private int maxNumb = 0;

    @Column(nullable = false)
    private Status status = Status.WAITING;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getListPositions() {
        return listPositions;
    }

    public void setListPositions(List<Long> listPositions) {
        this.listPositions = listPositions;
    }

    public int getMaxNumb() {
        return maxNumb;
    }

    public void setMaxNumb(int maxNumb) {
        this.maxNumb = maxNumb;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "(id:"+this.id+") status:"+this.status+" maxN:"+this.maxNumb+" pos:"+this.listPositions.toString();
    }
}
