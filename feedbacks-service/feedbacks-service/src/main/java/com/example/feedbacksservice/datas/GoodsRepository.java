package com.example.feedbacksservice.datas;

import com.example.feedbacksservice.models.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
