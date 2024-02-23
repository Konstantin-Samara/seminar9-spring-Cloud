package com.example.basketsservice.datas;

import com.example.basketsservice.models.BasketPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketPositionsRepository extends JpaRepository<BasketPosition, Long> {
}
