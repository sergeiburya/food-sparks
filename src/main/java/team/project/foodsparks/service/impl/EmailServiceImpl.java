package team.project.foodsparks.service.impl;

import java.io.IOException;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import team.project.foodsparks.service.EmailService;

@Component
@PropertySource("classpath:application.properties")
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String fromUserEmail;

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromUserEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendHtmlPage(String to, String subject, String token)
            throws MessagingException, IOException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");

        ClassPathResource resource = new ClassPathResource("static/confirmationLetter.html");
        String htmlMsg = new String(resource.getInputStream().readAllBytes());
        htmlMsg = htmlMsg.replace("{{token}}", token);

        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(fromUserEmail);
        emailSender.send(mimeMessage);
    }

    @Override
    public void sendEmailWithDocument(byte[] pdfBytes, String userEmail)
            throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        MimeBodyPart attachment = new MimeBodyPart();
        ByteArrayDataSource byteArrayDataSource
                = new ByteArrayDataSource(pdfBytes, "application/pdf");
        attachment.setDataHandler(new DataHandler(byteArrayDataSource));
        attachment.setFileName("order.pdf");
        MimeMultipart mimeMultipart = helper.getMimeMultipart();
        mimeMultipart.addBodyPart(attachment);
        helper.setFrom(fromUserEmail);
        helper.setTo(userEmail);
        helper.setSubject("Підтвердження замовлення");
        emailSender.send(message);
    }
}
