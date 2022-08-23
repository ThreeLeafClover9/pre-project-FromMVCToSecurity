package com.codestates.coffee.dto;

import com.codestates.validator.NotSpace;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Data
public class CoffeePatchDto {
    private Long coffeeId;

    @NotSpace
    private String korName;

    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$",
            message = "커피명(영문)은 영문이어야 합니다(단어 사이 공백 한 칸 포함). 예) Cafe Latte")
    private String engName;

    @Range(min = 100, max = 50000)
    private Integer price;


}
