package com.example.feedbacksservice.controllers;

import com.example.feedbacksservice.models.FeedBack;
import com.example.feedbacksservice.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedBackController {
    private final FeedBackService service;

    @Autowired
    public FeedBackController(FeedBackService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllFeedBacks() {

        return service.getAllFeedBacks();

    }

    @GetMapping ("/goods/{id}")
    public List<String> getAllFeedBacksOfGoods(@PathVariable Long id) {

        return service.getAllFeedBacksOfGoods(id);

    }

    @GetMapping("/{id}")
    public String getFeedBackById(@PathVariable Long id) {

        return service.getFeedBackById(id).toString();

    }

    @PostMapping
    public String createFeedBack(@RequestBody FeedBack note) {

        return service.createFeedBack(note).toString();

    }

    @DeleteMapping("/{id}")
    public void deleteFeedBack(@PathVariable Long id) {

        service.deleteFeedBack(id);

    }

}
