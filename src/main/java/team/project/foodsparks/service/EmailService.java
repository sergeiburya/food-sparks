package team.project.foodsparks.service;

import java.io.IOException;
import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendHtmlPage(String to, String subject, String token)
            throws MessagingException, IOException;

    void sendEmailWithDocument(byte[] pdfBytes, String userEmail) throws MessagingException;

    void sendHtmlCoupon(String to, String token) throws MessagingException, IOException;
}
