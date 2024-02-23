package com.example.feedbacksservice.datas;

import com.example.feedbacksservice.models.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}
