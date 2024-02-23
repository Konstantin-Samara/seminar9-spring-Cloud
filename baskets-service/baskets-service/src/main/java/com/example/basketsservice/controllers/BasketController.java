package com.example.basketsservice.controllers;

import com.example.basketsservice.models.BasketPosition;
import com.example.basketsservice.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baskets")
public class BasketController {
    private final BasketService service;

    @Autowired
    public BasketController(BasketService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> getAllBaskets() {
        return service.getAllBaskets();
    }

    @GetMapping("/{id}")
    public String getBasketById(@PathVariable long id) {
        return service.getBasketById(id).toString();
    }

    @PostMapping
    public String createBasket(@RequestBody BasketPosition note) {
        return service.createBasket(note);
    }

    @PostMapping("/{id}")
    public String addPositionToBasket(@PathVariable long id,@RequestBody BasketPosition note){
        return service.addPositionToBasket(id,note);}

    @DeleteMapping("/{id}")
    public void deleteBasket(@PathVariable Long id) {
        service.deleteBasket(id);
    }

    @DeleteMapping("/{idBasket}/{numbPos}")
    public void deletePositionFromNumb(@PathVariable long idBasket, @PathVariable int numbPos){
        service.deleteBasketPositionFromNumb(idBasket,numbPos);
    }

    @PutMapping("/{id}")
    public String orderBasket(@PathVariable long id){
        return service.orderBasket(id);
    }



}
