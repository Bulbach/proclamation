package by.alex.proclamation.persistence.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Slf4j
@Component
public class Cover {
    private static final String username_From = "farelkavkusnaya@gmail.com";
    final String password = "ufpamhnwwkgeyalk";
    private static final String to = "verezubovwork@yahoo.com";
    Session session = getSession();

    private Session getSession() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        return Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        log.debug("Session was created");
                        return new PasswordAuthentication(username_From, password);
                    }
                });
    }
    public Message createEmail(){
        return getMessage(session);
    }

    private Message getMessage(Session session) {

        Message message = new MimeMessage(session);
        try {
            // Установить От: поле заголовка.
            message.setFrom(new InternetAddress(username_From));

            // Установить Кому: поле заголовка
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        } catch (MessagingException e) {
            log.warn("Проблема при создании заявки(письма)");
            e.printStackTrace();
        }
        return message;
    }
}
