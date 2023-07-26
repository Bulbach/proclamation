package by.alex.proclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class ProclamationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProclamationApplication.class, args);
    }
}


