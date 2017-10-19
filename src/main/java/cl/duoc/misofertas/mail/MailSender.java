package cl.duoc.misofertas.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    private static final String USERNAME = "misofertas.noreply@gmail.com";
    private static final String PASSWORD = "misofertaspass";  //hackerman ¯\_(^-^)_/¯
    private static final Properties PROPS = new Properties();

    private static  void loadProperties() {
        PROPS.put("mail.smtp.starttls.enable", "true");
        PROPS.put("mail.smtp.auth", "true");
        PROPS.put("mail.smtp.host", "smtp.gmail.com");
        PROPS.put("mail.smtp.port", "587");
    }

    public static void send(String mailTo, String subject, String text) {
        loadProperties();
        
        try {
            Session session = Session.getInstance(PROPS,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(mailTo));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
