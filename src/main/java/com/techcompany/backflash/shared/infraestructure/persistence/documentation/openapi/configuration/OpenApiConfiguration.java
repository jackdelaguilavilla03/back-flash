package com.techcompany.backflash.shared.infraestructure.persistence.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI webserviceOpenApi(){
        final String securitySchemeName = "bearerAuth";
        var openApi = new OpenAPI();
        openApi
                .info(new Info().title("Webservice Flashporte API")
                        .description(
                                "Webservice Flashporte application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Webservice Flashporte Wiki Documentation")
                        .url("https://upc-pre-2023-SI729-SV52-TechCompany.wiki.github.org/docs"));
        // Add security scheme
        /*openApi
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));*/
        return openApi;
    }
}
