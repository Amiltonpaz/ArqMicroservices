package com.portifolio.msavaliadorcredito.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emitir-cartao}")
    private String emissaoCartoesFila;

    @Bean
    public Queue queueEmissaoCartoes() {
        return new Queue(emissaoCartoesFila, true);
    }
}
