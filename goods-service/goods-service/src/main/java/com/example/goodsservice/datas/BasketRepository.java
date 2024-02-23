package com.example.goodsservice.datas;

import com.example.goodsservice.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
