package com.codestates.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId) {
        Map<String, Long> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeId", coffeeId);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") long orderId) {
        return new ResponseEntity<>("getOrder() : " + orderId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        return new ResponseEntity<>("getOrders()", HttpStatus.OK);
    }

    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
