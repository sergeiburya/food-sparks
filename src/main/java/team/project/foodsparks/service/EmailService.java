package team.project.foodsparks.service;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendEmailWithDocument(byte[] pdfBytes, String userEmail);
}
