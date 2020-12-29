package com.adamant.locationservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Location Service")
                        .description("Location Service.")
                        .contact(new Contact()
                                .name("Daham")
                                .email("dahampositha33@gmail.com")
                                .url(""))
                        .extensions(Map.of(
                                "x-api-id", "location-api"
                        ))
                        .version("1.0.0")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("http://www.apache.org/licenses/LICENSE-2.0"))
                )
                .servers(List.of(
                        new Server()
                                .url("/")
                                .description("Local Server")));
    }
}
