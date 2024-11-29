package com.projeto.ReFood.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
      title = "ReFoods API", 
      description = "API para o projeto ReFoods", 
      version = "1.0.0", 
      contact = @Contact(
                          name = "Equipe ReFoods", 
                          email = "marinabarbosa.exp@gmail.com", 
                          url = ""
                        ), 
      license = @License(
        name = "Licença MIT", 
        url = "https://opensource.org/licenses/MIT"
      )
    ), 
    servers = {
      @Server(
        url = "http://localhost:8080", 
        description = "SERVIDOR DE DESENVOLVIMENTO"
      ),
      @Server(
        url = "", 
        description = "SERVIDOR DE PRODUÇÃO"
      )
    },
    security = @SecurityRequirement(name = "bearerAuth")
)
@SecuritySchemes({
    @SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
    )
})

public class SwaggerConfig {}
