package com.codestates.order.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class OrderPostDto {
    @Positive
    private String memberId;

    @Positive
    private String coffeeId;
}
