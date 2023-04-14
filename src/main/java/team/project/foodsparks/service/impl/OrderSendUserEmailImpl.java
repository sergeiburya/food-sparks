package team.project.foodsparks.service.impl;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
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
import team.project.foodsparks.exeption.DataProcessingException;
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
        document.setMargins(72, 36, 36, 36);
        Paragraph titleParagraph = new Paragraph("Thank you for your order.\n" +
                "Here are the details of your order.", FontFactory.getFont(FontFactory.TIMES, 12));
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setLeading(20f);
        document.add(titleParagraph);
        Paragraph orderNumParagraph = new Paragraph("Order Number: FS000" + order.getId(),
                FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE));
        orderNumParagraph.setAlignment(Element.ALIGN_CENTER);
        orderNumParagraph.setLeading(30f);
        document.add(orderNumParagraph);
        Paragraph dateParagraph = new Paragraph("Orders Time: " + order.getOrderTime()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
        dateParagraph.setAlignment(Element.ALIGN_RIGHT);
        dateParagraph.setLeading(20f);
        document.add(dateParagraph);
        Paragraph adrressParagraph = new Paragraph("Users Address: " + userAddress.getRegion() + ", "
                + userAddress.getTown()+ ", "
                + userAddress.getStreet()+ ", "
                + userAddress.getBuild()+ ", "
                + userAddress.getApartment());
        adrressParagraph.setAlignment(Element.ALIGN_LEFT);
        adrressParagraph.setLeading(20f);
        document.add(adrressParagraph);
        Paragraph userParagraph = new Paragraph("Users Name: " + user.getFirstName()
                + user.getLastName(), FontFactory.getFont(FontFactory.COURIER));
        userParagraph.setAlignment(Element.ALIGN_LEFT);
        userParagraph.setLeading(20f);
        document.add(userParagraph);
        Paragraph phoneParagraph = new Paragraph("Users Phone: " + user.getPhone());
        phoneParagraph.setLeading(20f);
        phoneParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(phoneParagraph);
        Paragraph orderParagraph = new Paragraph("Order Items:", FontFactory.getFont(FontFactory.HELVETICA));
        orderParagraph.setAlignment(Element.ALIGN_LEFT);
        orderParagraph.setLeading(20f);
        document.add(orderParagraph);
        Map<Product, Integer> productAmount = order.getProductAmount();
        for (Map.Entry<Product, Integer> entry : productAmount.entrySet()) {
            Paragraph itemParagraph = new Paragraph("Product Name: " + entry.getKey().getName().toUpperCase()
                    + " - " + entry.getValue());
            itemParagraph.setLeading(20f);
            itemParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(itemParagraph);
        }
        Paragraph totalSumparagraph = new Paragraph("Total Summa: " + order.getSum());
        totalSumparagraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalSumparagraph);
        Paragraph endParagraph = new Paragraph("We will be glad to welcome "
                + "you again in our store.\n"
                + "If you have any questions, "
                + "you can contact us at: foodsparksmail@gmail.com",
                FontFactory.getFont(FontFactory.TIMES, 12));
        endParagraph.setSpacingBefore(60f);
        endParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(endParagraph);
        document.close();

        byte[] pdfBytes = baos.toByteArray();

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");

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
            throw new DataProcessingException("A message with an order cant be sent.",e);
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
            throw new DataProcessingException("A message with an order cant be sent.",e);
        }
    }
}
