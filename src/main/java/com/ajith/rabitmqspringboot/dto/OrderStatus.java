package com.ajith.rabitmqspringboot.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatus {
    private Order order;
    private String status;
    private String message;

}
