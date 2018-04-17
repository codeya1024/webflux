package com.codeya.springboot.learning.webflux.router;

import com.codeya.springboot.learning.webflux.handler.CityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by codeya on 2018/4/17.
 */
@Configuration
public class CityRouter {


    /**RouterFunctions 对请求路由处理类，即将请求路由到处理器。
     * 这里将一个 GET 请求 /hello 路由到处理器 cityHandler 的 helloCity 方法上。
     * 跟 Spring MVC 模式下的 HandleMapping 的作用类似。
     * @param cityHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        cityHandler::helloCity);
    }

}