package pl.wszib.travelallowance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
//@PropertySource("classpath:db-template.properties")
public class TravelAllowanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAllowanceApplication.class, args);
    }

}
