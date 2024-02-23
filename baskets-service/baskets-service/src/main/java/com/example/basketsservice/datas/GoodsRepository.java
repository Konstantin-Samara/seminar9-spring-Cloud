package com.example.basketsservice.datas;

import com.example.basketsservice.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
