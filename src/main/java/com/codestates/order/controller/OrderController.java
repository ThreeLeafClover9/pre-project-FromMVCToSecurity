package com.codestates.order.controller;

import com.codestates.order.dto.OrderPostDto;
import com.codestates.order.dto.OrderResponseDto;
import com.codestates.order.entity.Order;
import com.codestates.order.mapper.OrderMapper;
import com.codestates.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public ResponseEntity postOrder(@RequestBody OrderPostDto orderPostDto) {
        Order order = orderMapper.orderPostDtoToOrder(orderPostDto);
        Order response = orderService.createOrder(order);
        return new ResponseEntity<>(orderMapper.orderToOrderResponseDto(response), HttpStatus.CREATED);
    }

    @GetMapping("/{order-id}")
    public ResponseEntity getOrder(@PathVariable("order-id") @Positive long orderId) {
        Order response = orderService.findOrder(orderId);
        return new ResponseEntity<>(orderMapper.orderToOrderResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getOrders() {
        List<Order> response = orderService.findOrders();
        List<OrderResponseDto> responseDto = response.stream()
                .map(order -> orderMapper.orderToOrderResponseDto(order))
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{order-id}")
    public ResponseEntity deleteOrder(@PathVariable("order-id") @Positive long orderId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
