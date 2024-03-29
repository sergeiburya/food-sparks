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
    private String fromEmail;
    @Value("${spring.mail.password}")
    private String mailPassword;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private boolean auth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private boolean starttlsEnable;
    @Value("${spring.mail.protocol}")
    private String protocol;

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
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
        htmlMsg = htmlMsg.replace("{{fromEmail}}", fromEmail);
        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(fromEmail);
        emailSender.send(mimeMessage);
    }

    @Override
    public void sendHtmlCoupon(String to, String coupon)
            throws MessagingException, IOException {
        ClassPathResource resource = new ClassPathResource("static/couponLetter.html");
        String couponMsg = new String(resource.getInputStream().readAllBytes());
        couponMsg = couponMsg.replace("{{coupon}}", coupon);
        couponMsg = couponMsg.replace("{{userEmail}}", to);
        couponMsg = couponMsg.replace("{{fromEmail}}", fromEmail);
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        messageHelper.setText(couponMsg, true);
        messageHelper.setTo(to);
        messageHelper.setSubject("Your discount coupon.");
        messageHelper.setFrom(fromEmail);
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
        helper.setFrom(fromEmail);
        helper.setTo(userEmail);
        helper.setSubject("Order confirmation");
        emailSender.send(message);
    }
}
