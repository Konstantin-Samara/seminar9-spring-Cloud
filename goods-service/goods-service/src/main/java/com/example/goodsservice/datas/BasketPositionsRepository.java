package com.example.goodsservice.datas;

import com.example.goodsservice.models.BasketPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketPositionsRepository extends JpaRepository<BasketPosition, Long> {
}
