package com.basic.authentication.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basic.authentication.project.utils.HttpDescription;

@Configuration
public class SwaggerConfig {

	@Value("${swagger.server.url}")
	private String environment;

	@Value("${springdoc.swagger-ui.path}")
	private String path;
	
	@Bean
    public OpenAPI OpenAPIDoc() {
        return new OpenAPI()
                .addServersItem(new Server().description("Server").url(this.environment))
                .components(
                        new Components().addSecuritySchemes(HttpDescription.SCHEME_NAME,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(HttpDescription.SCHEME)
                                        .name(HttpDescription.SCHEME_NAME)
                        		))
                .info(new Info().title("Basic Authentication API")
                        .description("API documentation of test api spring boot Project")
                        .version("1.0")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Powered with <3 by test")
                        .url(environment + path));
    }

}
