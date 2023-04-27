package team.project.foodsparks.service;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendHtmlPage(String to, String subject, String token) throws MessagingException, IOException;

    void sendEmailWithDocument(byte[] pdfBytes, String userEmail);
}
