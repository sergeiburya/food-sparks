package team.project.foodsparks.service.impl;

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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("foodsparksmail@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendHtmlPage(String to, String subject, String token) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "  <meta charset=\"UTF-8\">\n"
                + "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                + "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "  <title>Document</title>\n"
                + "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                + "  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                + "  <link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght"
                + "@400;600&display=swap\" rel=\"stylesheet\">\n"
                + "  <style>\n"
                + "    .body {\n"
                + "  box-sizing: border-box;\n"
                + "  font-family: 'Open Sans', sans-serif;\n"
                + "  color: #000000;\n"
                + "}\n"
                + "\n"
                + ".container {\n"
                + "  display: block;\n"
                + "  background: #F8F9FA;\n"
                + "  width: 854px;\n"
                + "  height: 643px;\n"
                + "  margin: 0 auto;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + ".header {\n"
                + "  display: flex;\n"
                + "  width: 100%;\n"
                + "  height: 88px;\n"
                + "  background-color: black;\n"
                + "}\n"
                + "\n"
                + ".hearer__block {\n"
                + "  display: flex;\n"
                + "  margin: auto;\n"
                + "  align-items: center;\n"
                + "}\n"
                + "\n"
                + ".hearer__title {\n"
                + "  height: 57px;\n"
                + "  width: 295px;\n"
                + "}\n"
                + "\n"
                + ".hearer__logo {\n"
                + "  display: flex;\n"
                + "  height: 40px;\n"
                + "  width: 40px;\n"
                + "}\n"
                + "\n"
                + ".main {\n"
                + "  font-family: 'Open Sans', sans-serif;\n"
                + "  margin-top: 40px;\n"
                + "  max-width: 594px;\n"
                + "  padding-left: 24px;\n"
                + "  font-weight: 600;\n"
                + "  font-style: normal;\n"
                + "  font-size: 24px;\n"
                + "  line-height: 36px;\n"
                + "}\n"
                + "\n"
                + ".button {\n"
                + "  position: relative;\n"
                + "  display: flex;\n"
                + "  justify-content: center;\n"
                + "  align-items: center;\n"
                + "  font-family: 'Open Sans';\n"
                + "  font-style: normal;\n"
                + "  font-weight: 400;\n"
                + "  font-size: 24px;\n"
                + "  line-height: 16px;\n"
                + "  margin: 60px auto 24px;\n"
                + "  width: 278px;\n"
                + "  height: 64px;\n"
                + "  background: #CB3C2E;\n"
                + "  border-radius: 12px;\n"
                + "  color: #FFFFFF;\n"
                + "  cursor: pointer;\n"
                + "  text-decoration: none;\n"
                + "  transition-duration: 0.4s;\n"
                + "}\n"
                + "\n"
                + ".button:active {\n"
                + "            transform: scale(0.98);\n"
                + "            box-shadow: 3px 2px 22px 1px rgba(0, 0, 0, 0.24);\n"
                + "        }\n"
                + "\n"
                + ".button:hover {\n"
                + "  background-color: #4CAF50; /* Green */\n"
                + "  color: white;\n"
                + "}\n"
                + "\n"
                + ".line {\n"
                + "  width: 818px;;\n"
                + "  height: 1px;\n"
                + "  margin-left: 24px;\n"
                + "  background-color: #ADB5BD;\n"
                + "  margin-top: 40px;\n"
                + "}\n"
                + "\n"
                + ".footer {\n"
                + "  font-family: 'Open Sans';\n"
                + "  font-weight: 400;\n"
                + "  font-style: normal;\n"
                + "  margin-top: 40px;\n"
                + "  padding-left: 24px;\n"
                + "  font-size: 16px;\n"
                + "  line-height: 24px;\n"
                + "}\n"
                + "  </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "  <div class=\"container\">\n"
                + "    <div class=\"header\">\n"
                + "      <div class=\"hearer__block\">\n"
                + "        <img class=\"hearer__logo\" "
                + "src=\"https://i.ibb.co/f41vx2Z/Group-115.png\" alt=\"Group\">\n"
                + "        <img class=\"hearer__title\" "
                + "src=\"https://i.ibb.co/TTcPkwh/Mask-group.png\" alt=\"Maskgroup\">\n"
                + "\n"
                + "      </div>\n"
                + "    </div>\n"
                + "\n"
                + "    <div class=\"main\">\n"
                + "      Привіт!\n"
                + "      <br>\n"
                + "      <br>\n"
                + "      Перш ніж ми почнемо, нам потрібно підтвердити, що це саме ви. "
                + "Натисніть нижче, щоб підтвердити свою електронну адресу:\n"
                + "    </div>\n"
                + "\n"
                + "    <a href=\"http://foodsparks.eu-central-1.elasticbeanstalk.com/verify?token="
                + token + "\" class=\"button\">Підтвердити</a>\n"
                + "\n"
                + "    <div class=\"line\"></div>\n"
                + "\n"
                + "    <div class=\"footer\">\n"
                + "      Потрібна допомога? Зверніться до нашої служби підтримки або напишіть нам."
                + " <br> Хочете залишити відгук? Повідомте нам, що ви думаєте, на нашому сайті"
                + " зворотного зв'язку.\n"
                + "    </div>\n"
                + "  </div>\n"
                + "</body>\n"
                + "</html>";
        helper.setText(htmlMsg, true); // Use this or above line.
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("foodsparksmail@gmail.com");
        emailSender.send(mimeMessage);
    }

    @Override
    public void sendEmailWithDocument(byte[] pdfBytes, String userEmail) {
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

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(userEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            message.setSubject("Your order details");
        } catch (MessagingException e) {
            throw new DataProcessingException("A message with an order cant be sent.");
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
            throw new DataProcessingException("A message with an order cant be sent.");
        }
    }
}
