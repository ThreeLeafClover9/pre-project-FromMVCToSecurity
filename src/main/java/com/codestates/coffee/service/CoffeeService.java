package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee findCoffee(long coffeeId) {
        Coffee foundCoffee = new Coffee(coffeeId, "아메리카노", "Americano", 4100);
        return foundCoffee;
    }

    public List<Coffee> findCoffees() {
        List<Coffee> foundCoffees = List.of(
                new Coffee(1L, "아메리카노", "Americano", 4100),
                new Coffee(2L, "카라멜 라떼", "Caramel Latte", 5100));
        return foundCoffees;
    }

    public void deleteCoffee(long coffeeId) {

    }
}
