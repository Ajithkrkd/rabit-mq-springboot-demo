package com.ajith.rabitmqspringboot.consumer;

import com.ajith.rabitmqspringboot.config.RabbitMqConfig;
import com.ajith.rabitmqspringboot.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @RabbitListener(queues = RabbitMqConfig.QUEUE )
    public void consumeMessage(OrderStatus orderStatus)
    {
        log.info ( "message from the queue ::  "+ orderStatus );
    }
}
