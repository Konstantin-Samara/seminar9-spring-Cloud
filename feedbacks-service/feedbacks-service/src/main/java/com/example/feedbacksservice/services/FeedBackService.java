package com.example.feedbacksservice.services;

import com.example.feedbacksservice.annotacions.LoggedExecution;
import com.example.feedbacksservice.datas.FeedBackRepository;
import com.example.feedbacksservice.datas.GoodsRepository;
import com.example.feedbacksservice.models.FeedBack;
import com.example.feedbacksservice.models.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;
    @Autowired
    private GoodsRepository goodsRepository;


    public FeedBack createFeedBack(FeedBack note) {

        Goods tempGoods = goodsRepository.findById(note.getIdGoods())
                .orElseThrow(() -> new RuntimeException("Goods with ID:"+note.getIdGoods()+"  not found"));

        return feedBackRepository.save(note);

    }

    public List<String> getAllFeedBacks() {

        return feedBackRepository.findAll().stream()
                .sorted(Comparator.comparing(FeedBack::getIdGoods))
                .map(FeedBack::toString).toList();

    }
    public List<String> getAllFeedBacksOfGoods(long id) {

        return feedBackRepository.findAll().stream()
                .filter(it->it.getIdGoods()==id)
                .sorted(Comparator.comparing(FeedBack::getDate))
                .map(FeedBack::toString).toList();
    }

    public FeedBack getFeedBackById(long id) {

        FeedBack feedBack = feedBackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FeedBack with ID:"+id+"  not found"));
        return feedBack;

    }

    @LoggedExecution
    public void deleteFeedBack(long id) {

        FeedBack feedBack = getFeedBackById(id);
        feedBackRepository.delete(feedBack);

    }



}
