package by.alex.proclamation;

import by.alex.proclamation.controller.Temp;
import by.alex.proclamation.model.Letter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
public class ProclamationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProclamationApplication.class, args);
        Temp temp = new Temp();
        temp.change();
    }
}


