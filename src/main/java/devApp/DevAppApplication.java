package devApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class DevAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevAppApplication.class, args);
    }
}
