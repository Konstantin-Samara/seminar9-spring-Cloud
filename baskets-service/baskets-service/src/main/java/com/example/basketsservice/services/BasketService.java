package com.example.basketsservice.services;

import com.example.basketsservice.annotacions.LoggedExecution;
import com.example.basketsservice.datas.BasketPositionsRepository;
import com.example.basketsservice.datas.BasketRepository;
import com.example.basketsservice.datas.GoodsRepository;
import com.example.basketsservice.models.Basket;
import com.example.basketsservice.models.BasketPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class BasketService {
    @Autowired
    private BasketPositionsRepository basketPositionsRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private GoodsRepository goodsRepository;

    public String createBasket(BasketPosition note) {

        BasketPosition position = basketPositionsRepository.save(note);
        Basket basket = basketRepository.save(new Basket());
        basket.getListPositions().add(position.getId());
        basket.setMaxNumb(basket.getMaxNumb()+1);
        position.setIdBasket(basket.getId());
        position.setNumbInBasket(basket.getMaxNumb());
        basketPositionsRepository.save(position);
        return basketRepository.save(basket).toString();

    }

    public String addPositionToBasket(long id,BasketPosition note){
        Basket tempBasket = getBasketById(id);
        long existingPosId = tempBasket.getListPositions().stream()
                .filter(it->getBasketPositionById(it).getIdGoods()==note.getIdGoods())
                .findFirst().orElse(0L);
        if (existingPosId!=0){
            BasketPosition existingPos = getBasketPositionById(existingPosId);
            existingPos.setCount(existingPos.getCount()+ note.getCount());
            basketPositionsRepository.save(existingPos);
        }
        else{
            BasketPosition position = basketPositionsRepository.save(note);
            position.setIdBasket(id);
            tempBasket.setMaxNumb(tempBasket.getMaxNumb()+1);
            position.setNumbInBasket(tempBasket.getMaxNumb());
            basketPositionsRepository.save(position);
            tempBasket.getListPositions().add(position.getId());
        }

        return basketRepository.save(tempBasket).toString();
    }

    public List<String> getAllBaskets() {

        return basketRepository.findAll().stream()
                .sorted(Comparator.comparing(Basket::getId))
                .map(Basket::toString).toList();

    }


    @LoggedExecution
    public void deleteBasket(long id) {

        Basket tempBasket = getBasketById(id);
        tempBasket.getListPositions().forEach(it->{basketPositionsRepository.deleteById(it);});
        basketRepository.delete(tempBasket);

    }

    public Basket getBasketById(long id) {

        Basket tempBasket = basketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Basket with ID:"+id+"  not found"));
        return tempBasket;

    }

    public List<String> getAllBasketPositions() {

        return basketPositionsRepository.findAll().stream()
            .sorted(Comparator.comparing(BasketPosition::getIdBasket))
            .map(BasketPosition::toString).toList();

    }

    public BasketPosition getBasketPositionById(long id) {

        BasketPosition position = basketPositionsRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("BasketPosition with ID:"+id+"  not found"));
        return position;

    }

    public void deleteBasketPosition(long id) {

        BasketPosition position = getBasketPositionById(id);
        basketPositionsRepository.delete(position);

    }

    public void deleteBasketPositionFromNumb(long id,int numb){

        Basket basket = getBasketById(id);
        long positionId = basket.getListPositions().stream()
            .filter(it->getBasketPositionById(it).getNumbInBasket()==numb)
                .findFirst().orElse(0L);
        if (positionId!=0){
            basketPositionsRepository.deleteById(positionId);
            basket.getListPositions().remove(positionId);
            updateBasketNumb(basket);
        }

    }

    private void updateBasketNumb(Basket basket){

        for (int i = 0; i < basket.getListPositions().size(); i++) {
            BasketPosition tempPosition = getBasketPositionById(basket.getListPositions().get(i));
            tempPosition.setNumbInBasket(i+1);
            basketPositionsRepository.save(tempPosition);
        }
        basket.setMaxNumb(basket.getListPositions().size());
        basketRepository.save(basket);

    }

    public String orderBasket(long id) {

        Basket basket = getBasketById(id);
        basket.setStatus(Basket.Status.ORDERED);
        basketRepository.save(basket);
        return basketRepository.save(basket).toString();
    }
    
}
