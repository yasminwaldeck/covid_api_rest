package de.neuefische.corona_rest_temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CoronaRestTempApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoronaRestTempApplication.class, args);
    }

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

}
