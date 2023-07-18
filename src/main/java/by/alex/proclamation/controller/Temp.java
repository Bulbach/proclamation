package by.alex.proclamation.controller;

import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Temp {
    final String username_From = "alexverezubov@gmail.com";
    final String password = "jltnbuthcqaswlyz";
    final String to = "zverovik@yahoo.com";
    @Value("${mail.smtp.host}")
  private  String host;

    public void change() {
        System.out.println(host);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username_From, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            // Установить От: поле заголовка.
            message.setFrom(new InternetAddress(username_From));

            // Установить Кому: поле заголовка
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
