package com.example.basketsservice.controllers;

import com.example.basketsservice.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
public class BasketPositionController {
    private final BasketService service;

    @Autowired
    public BasketPositionController(BasketService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllBasketPosition() {
        return service.getAllBasketPositions();
    }

    @GetMapping("/{id}")
    public String getBasketPositionById(@PathVariable Long id) {
        return service.getBasketPositionById(id).toString();
    }

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable Long id) {
        service.deleteBasketPosition(id);
    }





}
