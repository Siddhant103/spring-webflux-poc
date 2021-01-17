package com.reactivepocproject.reactivepocproject.router;

import com.reactivepocproject.reactivepocproject.handler.FluxAndMonoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> route(FluxAndMonoHandler fluxAndMonoHandler){
        return RouterFunctions
                .route(GET("/functional/flux").and(accept(MediaType.APPLICATION_JSON)),fluxAndMonoHandler::flux)
                .andRoute(GET("/functional/mono").and(accept(MediaType.APPLICATION_JSON)),fluxAndMonoHandler::mono);
    }
}
