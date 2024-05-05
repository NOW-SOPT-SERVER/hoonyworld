package com.sopt.carrotmarket.swagger;

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
                        .title("Carrot Market Project API")
                        .description("내 물건 팔기 작성, 물건 등록, 등록된 상품들 지역별 리스트, 상품 좋아요 기능을 제공합니다")
                        .version("1.0.0"));
    }
}
