package com.gajula.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;


@Configuration
@EnableWebMvc
public class OpenAPIConfig {

    private final static Logger admin = LogManager.getLogger(OpenAPIConfig.class.getName());

    @Value("${gajula.openapi.dev-url}")
    private String devUrl;

    @Value("${gajula.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {

        admin.info("Start myOpenAPI ");
        Server devServer = new Server();
        devServer.setDescription("Development");
        devServer.setUrl(devUrl);
        Server prodServer = new Server();
        prodServer.setDescription("Production");
        prodServer.setUrl(prodUrl);
        admin.info("End myOpenAPI ");

        return new OpenAPI()
                .servers(List.of(devServer, prodServer))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("jwt")
                                .in(SecurityScheme.In.HEADER)))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }

}
