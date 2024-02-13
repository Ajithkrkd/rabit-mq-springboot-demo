package com.ajith.rabitmqspringboot.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE = "demo_exchange";
    public static final String QUEUE = "demo_queue";
    public static final String ROUTING_KEY = "demo_routing_key";

    @Bean
    public Queue queue()
    {
        return new Queue( QUEUE );
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange( EXCHANGE );
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder.bind (queue).to ( exchange ).with ( ROUTING_KEY );
    }


    @Bean
    public MessageConverter converter()
    {
        return new Jackson2JsonMessageConverter (  );
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory factory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate ( factory );
        rabbitTemplate.setMessageConverter ( converter () );
        return rabbitTemplate;
    }
}
