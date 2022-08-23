package com.codestates.member.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
