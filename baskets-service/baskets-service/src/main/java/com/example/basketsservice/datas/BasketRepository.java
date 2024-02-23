package com.example.basketsservice.datas;

import com.example.basketsservice.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
