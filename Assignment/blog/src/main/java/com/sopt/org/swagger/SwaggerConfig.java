package com.sopt.org.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blog Project API")
                        .description("멤버를 등록하고 멤버 별 블로그를 관리하고 블로그 별 글을 관리하는 기능을 제공합니다")
                        .version("1.0.0"));
    }
}

