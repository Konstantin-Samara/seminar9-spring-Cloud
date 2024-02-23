package com.example.goodsservice.datas;

import com.example.goodsservice.models.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}
