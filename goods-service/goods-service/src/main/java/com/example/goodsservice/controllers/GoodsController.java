package com.example.goodsservice.controllers;

import com.example.goodsservice.models.Goods;
import com.example.goodsservice.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    private final GoodsService service;

    @Autowired
    public GoodsController(GoodsService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllGoods() {
        return service.getAllGoods();
    }

    @GetMapping("/{id}")
    public String getGoodsById(@PathVariable Long id) {
        return service.getGoodsById(id).toString();
    }

    @PostMapping
    public String createGoods(@RequestBody Goods note) {
        return service.createGoods(note).toString();
    }

    @DeleteMapping("/{id}")
    public void deleteGoods(@PathVariable Long id) {
        service.deleteGoods(id);
    }





}
