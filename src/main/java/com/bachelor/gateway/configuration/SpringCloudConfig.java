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
                .route(r -> r.path("/login", "/signup", "/my/**", "/remove")
                        .uri("http://localhost:8083/")
                        .id("authService"))

                .route(r -> r.path("/gyms/**", "/offers/**")
                        .uri("http://localhost:8081/")
                        .id("employeeService"))

                .route(r -> r.path("/users/**")
                        .uri("http://localhost:8082/")
                        .id("employeeConsumer"))
                .build();
    }
}
