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
                        .title("Member Project API")
                        .description("멤버를 생성하고, 찾고, 삭제하는 기능을 제공합니다")
                        .version("1.0.0"));
    }
}

