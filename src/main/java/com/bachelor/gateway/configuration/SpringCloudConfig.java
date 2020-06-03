package com.bachelor.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/login", "/signup")
                        .uri("http://localhost:8083/")
                        .id("authService"))

                .route(r -> r.path("/employee/**")
                        .uri("http://localhost:8081/")
                        .id("employeeModule"))

                .route(r -> r.path("/**")
                        .uri("http://localhost:8082/")
                        .id("consumerModule"))
                .build();
    }
}
