package net.fullstack7.springboot.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(appInfo());
    }

    private Info appInfo (){
        return new Info()
                .title("스웨거 API")
                .description("REST 스웨거 API")
                .version("1.0.0");
    }


}
