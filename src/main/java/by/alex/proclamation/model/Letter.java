package by.alex.proclamation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Size;
import java.util.Properties;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Letter {

    private String name;
    private String mail;
    private String phone;
    private String proff;

}

