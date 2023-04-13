package team.project.foodsparks.service.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.AddressService;
import team.project.foodsparks.service.OrderSendUserEmail;

@Service
public class OrderSendUserEmailImpl implements OrderSendUserEmail {
    private final AddressService addressService;

    @Autowired
    public OrderSendUserEmailImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void sendOrderEmail(Order order) throws DocumentException {
        User user = order.getUser();
        String userEmail = order.getUser().getEmail();
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        Address userAddress = addressService.findByUser(user).orElseThrow(
                () -> new RuntimeException("Address with user " + user + "not found"));
        document.open();
        document.add(new Paragraph("User Region: " + userAddress.getRegion()));
        document.add(new Paragraph("User Town: " + userAddress.getTown()));
        document.add(new Paragraph("User Street: " + userAddress.getStreet()));
        document.add(new Paragraph("User Build: " + userAddress.getBuild()));
        document.add(new Paragraph("User Apartment: " + userAddress.getApartment()));
        document.add(new Paragraph("Order Number: " + order.getId()));
        document.add(new Paragraph("Order Time: " + order.getOrderTime()));
        document.add(new Paragraph("User Name: " + user.getFirstName() + user.getLastName()));
        document.add(new Paragraph("User Phone: " + user.getPhone()));

        document.add(new Paragraph("Order Items:"));

        Map<Product, Integer> productAmount = order.getProductAmount();
        for (Map.Entry<Product, Integer> entry : productAmount.entrySet()) {
            document.add(new Paragraph(entry.getKey().getName() + " - " + entry.getValue()));
        }
        document.add(new Paragraph("Total: " + order.getSum()));
        document.close();

        byte[] pdfBytes = baos.toByteArray();

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth","true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("foodsparksmail@gmail.com", "avcayxyeboohjvad");
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(userEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Your order details");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        Multipart multipart = new MimeMultipart();
        MimeBodyPart attachmentPart = new MimeBodyPart();
        try {
            attachmentPart.setFileName("order.pdf");
            attachmentPart.setContent(pdfBytes, "application/pdf");
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
