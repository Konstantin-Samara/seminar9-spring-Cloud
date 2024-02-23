package com.example.goodsservice.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Basket {

    private enum Status {ORDERED, WAITING}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private List<Long> listPositions;

    @Column(nullable = false)
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
}
