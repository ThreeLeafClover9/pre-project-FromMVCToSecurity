package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> coffee = new HashMap<>();
        long coffeeId = 1L;
        coffee.put("coffeeId", coffeeId);
        coffee.put("korName", "바닐라 라떼");
        coffee.put("engName", "Vanilla Latte");
        coffee.put("price", 4600);
        coffees.put(coffeeId, coffee);
    }

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("korName") String engName,
                                     @RequestParam("engName") String korName,
                                     @RequestParam("price") int price) {
        Map<String, Object> map = new HashMap<>();
        map.put("engName", engName);
        map.put("korName", korName);
        map.put("price", price);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        return new ResponseEntity<>("getCoffee() : " + coffeeId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        return new ResponseEntity<>("getCoffees()", HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId,
                                      @RequestParam("korName") String korName,
                                      @RequestParam("price") int price) {
        Map<String, Object> coffee = coffees.get(coffeeId);
        coffee.put("korName", korName);
        coffee.put("price", price);
        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        coffees.remove(coffeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
