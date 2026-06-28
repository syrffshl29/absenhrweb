package com.miniproject.absenhrweb.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    private final HttpSession session;

    public FeignConfig(HttpSession session) {
        this.session = session;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {

        return template -> {

            String token =
                    (String) session.getAttribute("TOKEN");

            if (token != null) {

                template.header(
                        "Authorization",
                        "Bearer " + token
                );

            }

        };

    }

}