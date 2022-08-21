package com.codestates.order;

import com.codestates.order.dto.OrderPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
    @PostMapping
    public ResponseEntity postOrder(@RequestBody OrderPostDto orderPostDto) {
        return new ResponseEntity<>(orderPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{order-id}")
    public ResponseEntity patchOrder(@PathVariable("order-id") @Positive long orderId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
