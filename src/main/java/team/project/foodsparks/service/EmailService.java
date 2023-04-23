package team.project.foodsparks.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendHtmlPage(String to, String subject, String token) throws MessagingException;

    void sendEmailWithDocument(byte[] pdfBytes, String userEmail);
}
