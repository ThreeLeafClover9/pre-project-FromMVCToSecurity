package com.codestates.order.dto;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class OrderPostDto {
    @Positive
    private String memberId;

    @Positive
    private String coffeeId;
}
