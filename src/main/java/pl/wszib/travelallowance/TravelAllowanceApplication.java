package pl.wszib.travelallowance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:ds.properties")
@SpringBootApplication
public class TravelAllowanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelAllowanceApplication.class, args);
    }

}
