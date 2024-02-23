package com.example.goodsservice.services;

import com.example.goodsservice.annotacions.LoggedExecution;

import com.example.goodsservice.datas.BasketPositionsRepository;
import com.example.goodsservice.datas.BasketRepository;
import com.example.goodsservice.datas.FeedBackRepository;
import com.example.goodsservice.datas.GoodsRepository;
import com.example.goodsservice.models.Basket;
import com.example.goodsservice.models.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
@Service
public class GoodsService {
    @Autowired
    private BasketPositionsRepository basketPositionsRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private FeedBackRepository feedBackRepository;
    @Autowired
    private GoodsRepository goodsRepository;


    public Goods createGoods(Goods note) {

        Goods existingGoods =
                goodsRepository.findAll().stream()
            .filter(it->(
                    note.getName().equals(it.getName())
                    &&note.getDescription().equals(it.getDescription())
                    &&note.getPrice().equals(it.getPrice())))
            .findFirst().orElse(null);

        if (existingGoods!=null){
            /*
            При создании новой позиции товара, если такая уже есть в каталоге -
            здесь будет увеличение кол-ва существующей позиции на кол-во добавляемой,
            если создадим сущность "склад" {long idGoods : int countGoods} и будем администрировать кол-во
            Пока это кажется избыточным
            */
            note.setId(existingGoods.getId());
        }
        return goodsRepository.save(note);

    }

    public List<String> getAllGoods() {

        return goodsRepository.findAll().stream()
                .sorted(Comparator.comparing(Goods::getId))
                .map(Goods::toString).toList();

    }

    public Goods getGoodsById(long id) {

        Goods goods = goodsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goods with ID:"+id+"  not found"));
        return goods;

    }

    @LoggedExecution
    public void deleteGoods(long id) {

        Goods tempGoods = getGoodsById(id);
        deleteFeedBackFromGoodsId(id);
        deleteBasketPositionFromGoodsId(id);
        goodsRepository.delete(tempGoods);

    }

    private Basket getBasketById(long id) {

        Basket tempBasket = basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket with ID:"+id+"  not found"));
        return tempBasket;

    }

    private void deleteFeedBackFromGoodsId(long id){

        feedBackRepository.findAll().stream().filter(it->it.getIdGoods()==id).toList()
                .forEach(it1->{feedBackRepository.delete(it1);});

    }
    private void deleteBasketPositionFromGoodsId(long id){

        basketPositionsRepository.findAll().stream().filter(it->it.getIdGoods()==id).toList()
                .forEach(it1->{
                    Basket tempBasket = getBasketById(it1.getIdBasket());
                    tempBasket.getListPositions().remove(it1.getId());
                    basketRepository.save(tempBasket);
                    basketPositionsRepository.delete(it1);
                });

    }

}
