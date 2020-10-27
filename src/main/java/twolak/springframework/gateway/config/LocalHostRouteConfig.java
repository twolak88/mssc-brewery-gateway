/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twolak.springframework.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author twolak
 */
@Configuration
public class LocalHostRouteConfig {
    
    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(r -> r.path("/api/v1/beer","/api/v1/beer/*", "/api/v1/beerUpc/*")
                    .uri("http://localhost:8080")
                    .id("beer-service"))
                .route(r -> r.path("/api/v1/customers/**")
                    .uri("http://localhost:8081")
                    .id("beer-order-service"))
                .route(r -> r.path("/api/v1/beer/*/inventory")
                    .uri("http://localhost:8082")
                    .id("beer-inventory-service"))
                .build();
    }
}
