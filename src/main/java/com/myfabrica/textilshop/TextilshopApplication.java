package com.myfabrica.textilshop;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ComponentScan(basePackages = {"com.myfabrica.entities",
                                "com.myfabrica.restcontrollers",
                                "com.myfabrica.config"
})
public class TextilshopApplication {

    @Value( "${app.name}" )
    private String appName;
    
    public static void main(String[] args) {
        SpringApplication.run(TextilshopApplication.class, args);
    }

    @Bean
    @Primary
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        final String app = appName;
        return (String[] args) -> {
            System.out.println("APP: ------ " + app);
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
    
}
