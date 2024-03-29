package com.ajith.rabitmqspringboot.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String order_id;
    private String name;
    private int quantity;
    private double price;
}
