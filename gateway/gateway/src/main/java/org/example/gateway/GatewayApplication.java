package org.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(
            RouteLocatorBuilder builder,
            @Value("${routing.gateway.host}") String host,
            @Value("${routing.teachers.url}") String teachersUrl,
            @Value("${routing.classes.url}") String classesUrl) {
        return builder.routes()
                .route("teacher", r -> r
                        .host(host)
                        .and()
                        .path("/api/teacher/create", "/api/teacher", "/api/teacher/{uuid}", "/api/teacher/update/{uuid}", "/api/teacher/get/{uuid}")
                        .uri(teachersUrl)
                )
                .route("classes", r -> r
                        .host(host)
                        .and()
                        .path("/api/class/create", "/api/class", "/api/class/{uuid}", "/api/class/update/{uuid}")
                        .uri(classesUrl)
                )
                .build();
    }

}
