package tn.esprit.louaybennoamen4emecce11.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI locationVehiculesOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API Location de véhicules")
                .description("API REST de gestion des agences, des véhicules et des contrats")
                .version("1.0.0")
                .contact(new Contact().name("Louay Ben Noamen")));
    }
}
