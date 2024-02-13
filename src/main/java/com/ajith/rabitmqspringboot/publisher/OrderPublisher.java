package com.ajith.rabitmqspringboot.publisher;

import com.ajith.rabitmqspringboot.config.RabbitMqConfig;
import com.ajith.rabitmqspringboot.dto.Order;
import com.ajith.rabitmqspringboot.dto.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderPublisher {

    public static final String PROCESSING = "PROCESSING";
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String placeOrder(@RequestBody Order order , @PathVariable("restaurantName") String restaurantName)
    {
        order.setOrder_id ( UUID.randomUUID ().toString ());
        // TODO restaurant logic
        // TODO payment logic
        OrderStatus orderStatus = new OrderStatus ( order , PROCESSING , "your order placed successfully with  "+ restaurantName );
        rabbitTemplate.convertAndSend ( RabbitMqConfig.EXCHANGE ,RabbitMqConfig.ROUTING_KEY,orderStatus );
        return "Your order placed successfully with "+ restaurantName;
    }
}
