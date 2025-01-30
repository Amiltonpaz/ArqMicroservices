package com.portifolio.mscloudgateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public ReactiveResilience4JCircuitBreakerFactory reactiveResilience4JCircuitBreakerFactory() {
        CircuitBreakerRegistry cicruitBreaker = CircuitBreakerRegistry.custom().build();
        TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.ofDefaults();

        return new ReactiveResilience4JCircuitBreakerFactory(cicruitBreaker,timeLimiterRegistry);
    }


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/clientes/**")
                        .filters( f -> f.circuitBreaker(c ->
                                c.setName("circuitBreakerMsclientes")
                                        .setFallbackUri("forward:/rotaDeFallback")))
                        .uri("lb://msclientes"))
                .route(r -> r.path("/cartoes/**")
                        .filters( f -> f.circuitBreaker(c ->
                                c.setName("circuitBreakerMscartoes")
                                        .setFallbackUri("forward:/rotaDeFallback")))
                        .uri("lb://mscartoes"))
                .build();
    }


}
