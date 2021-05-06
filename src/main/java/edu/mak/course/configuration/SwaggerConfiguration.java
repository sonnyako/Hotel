package edu.mak.course.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.*;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI travellerOpenAPI() {
        return new OpenAPI()
            .info(
                new Info().title("Course Work - Hotel")
                    .version("1.0")
                    .contact(new Contact()
                        .email("makydon.sofiia@chnu.edu.ua")
                        .name("Makydon Sofiia"))
            );

    }
}
