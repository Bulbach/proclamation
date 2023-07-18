package by.alex.proclamation.model;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Сover {
    private static final String username_From = "alexverezubov@gmail.com";
    final String password = "jltnbuthcqaswlyz";
    private static final String to = "zverovik@yahoo.com";
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
                        return new PasswordAuthentication(username_From, password);
                    }
                });
    }

    public static Message getMessage(Session session) {

        Message message = new MimeMessage(session);
        try {
            // Установить От: поле заголовка.
            message.setFrom(new InternetAddress(username_From));

            // Установить Кому: поле заголовка
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }
}
