package com.kb._config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("게시판 REST API")
                        .version("1.0")
                        .description("게시판 관련 REST API 문서")
                        .contact(new Contact().name("MyHome").url("http://myhome.co.kr").email("test@test.email"))
                        .license(new License().name("마이시스템").url("http://myhome.co.kr"))
                );
    }

}
