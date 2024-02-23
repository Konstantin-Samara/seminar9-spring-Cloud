package com.example.gatewayservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class SpringCloudConfig {
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("goods-service",r->r.path("api/goods/**")
//                        .uri("http://localhost:8081/"))
//                .route("basket-service",r->r.path("api/baskets/**")
//                        .uri("http://localhost:8082/"))
//                .route("feedback-service",r->r.path("api/feedback/**")
//                        .uri("http://localhost:8083/"))
//                .build();
//    }
}
