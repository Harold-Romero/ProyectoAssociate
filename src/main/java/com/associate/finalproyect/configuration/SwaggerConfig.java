package com.associate.finalproyect.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Development by Harol Romero
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configure been swagger documentation
     * @return = new Object Docket with configuration the controller path
     */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.associate.finalproyect.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
