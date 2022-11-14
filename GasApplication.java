package com.example.gas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@OpenAPIDefinition(
//        info = @Info(
//                title = "GAS",
//                version = "1",
//                description = "GAS",
//                contact = @Contact(name = "gas", email = "gas@gmail.com")))
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer")
@SpringBootApplication
public class GasApplication {

    public static void main(String[] args) {
        SpringApplication.run(GasApplication.class, args);
    }
}
