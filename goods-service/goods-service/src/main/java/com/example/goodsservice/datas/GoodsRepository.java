package com.example.goodsservice.datas;

import com.example.goodsservice.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
