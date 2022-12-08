package co.develhope.email2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Benvenuto!</h1>" +
                "<h2>Hai ricevuto un nuovo messaggio!!!</h2>" +
                "<img src='https://siviaggia.it/wp-content/uploads/sites/2/2020/11/dolomiti-montagna-neve-inverno.jpg?w=1192&h=671&crop=1&quality=90&strip=all' alt='Alternative text' height='200'>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("esercizioemail@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
