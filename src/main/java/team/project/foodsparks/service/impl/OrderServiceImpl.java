package team.project.foodsparks.service.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exeption.DataProcessingException;
import team.project.foodsparks.model.Coupon;
import team.project.foodsparks.model.DeliveryInformation;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.repository.OrderRepository;
import team.project.foodsparks.service.CouponService;
import team.project.foodsparks.service.DeliveryInformationService;
import team.project.foodsparks.service.EmailService;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;
import team.project.foodsparks.util.ProductAmountConverter;

@Service
public class OrderServiceImpl implements OrderService {
    private static final String FONT_PATH = "/fonts/arialuni.ttf";
    private static final String LOGO_PATH = "src/main/resources/static/img/logo.jpg";
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final EmailService emailService;
    private final CouponService couponService;
    private final DeliveryInformationService deliveryInformationService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            EmailService emailService,
                            CouponService couponService,
                            DeliveryInformationService deliveryInformationService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.emailService = emailService;
        this.couponService = couponService;
        this.deliveryInformationService = deliveryInformationService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart,
                               DeliveryInformation deliveryInformation) {
        DeliveryInformation savedDeliveryInformation
                = deliveryInformationService.add(deliveryInformation);
        Order order = new Order();
        order.setDeliveryInformation(savedDeliveryInformation);
        order.setOrderTime(LocalDateTime.now());
        order.setProductAmount(new HashMap<>(shoppingCart.getProductAmount()));
        order.setUser(shoppingCart.getUser());
        order.setSum(shoppingCart.getProductAmount()
                .entrySet()
                .stream()
                .map(e -> e.getKey().getPrice()
                        .multiply(BigDecimal.valueOf(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(100))
                .multiply(BigDecimal.valueOf(shoppingCart.getCoupon() != null
                        ? 100 - shoppingCart.getCoupon().getDiscountSize() : 100)));
        orderRepository.save(order);
        Coupon coupon = shoppingCart.getCoupon();
        if (coupon != null) {
            coupon.setExpired(true);
            couponService.update(coupon);
        }
        try {
            createAndSendPdfOrderForUser(order);
        } catch (DocumentException e) {
            throw new DataProcessingException("A message with an order cant be sent.");
        } catch (IOException e) {
            throw new DataProcessingException("IO exception happened");
        }
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrders(User user) {
        return orderRepository.findAll();
    }

    @Override
    public void createAndSendPdfOrderForUser(Order order) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setPdfVersion(PdfWriter.VERSION_1_7);
        document.open();
        Image logoImage = Image.getInstance(LOGO_PATH);
        logoImage.scaleAbsolute(250f, 20f);
        logoImage.setIndentationLeft(135f);
        Paragraph lineSeparator = new Paragraph();
        lineSeparator.add(new LineSeparator());
        lineSeparator.setLeading(10f);
        document.setMargins(72, 36, 36, 36);
        document.add(logoImage);
        BaseFont bf = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font arialFont = new Font(bf, 12);
        Paragraph titleParagraph = new Paragraph("Дякуємо за Ваше замовлення. "
                + "Деталі замовлення.", arialFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setLeading(10f);
        document.add(titleParagraph);
        Paragraph orderNumParagraph = new Paragraph("Номер замовлення: \n FS000" + order.getId(),
                arialFont);
        orderNumParagraph.setAlignment(Element.ALIGN_CENTER);
        orderNumParagraph.setLeading(30f);
        document.add(orderNumParagraph);
        document.add(lineSeparator);
        Paragraph dateParagraph = new Paragraph("Дата та час замовлення: " + order.getOrderTime()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")),
                arialFont);
        dateParagraph.setAlignment(Element.ALIGN_RIGHT);
        dateParagraph.setLeading(30f);
        document.add(dateParagraph);
        DeliveryInformation deliveryInformation = order.getDeliveryInformation();
        Paragraph adrressParagraph = new Paragraph("Адреса доставки: "
                + deliveryInformation.getTown() + ", "
                + deliveryInformation.getStreet() + ", "
                + deliveryInformation.getBuild() + ", "
                + deliveryInformation.getApartment(), arialFont);
        adrressParagraph.setAlignment(Element.ALIGN_LEFT);
        adrressParagraph.setLeading(30f);
        document.add(adrressParagraph);
        Paragraph userParagraph = new Paragraph("Ім'я користувача: "
                + deliveryInformation.getFirstName()
                + " " + deliveryInformation.getLastName(),
                arialFont);
        userParagraph.setAlignment(Element.ALIGN_LEFT);
        userParagraph.setLeading(30f);
        document.add(userParagraph);
        Paragraph phoneParagraph = new Paragraph("Тел.: "
                + deliveryInformation.getPhone(),
                arialFont);
        phoneParagraph.setLeading(30f);
        phoneParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(phoneParagraph);
        Paragraph deliveryTimeParagraf = new Paragraph();
        deliveryTimeParagraf.setLeading(30f);
        document.add(deliveryTimeParagraf);
        Paragraph deliveryDayParagraf = new Paragraph();
        deliveryDayParagraf.setLeading(30f);
        document.add(deliveryDayParagraf);
        Paragraph orderParagraph = new Paragraph("Список товарів:",
                arialFont);
        orderParagraph.setAlignment(Element.ALIGN_LEFT);
        orderParagraph.setLeading(40f);
        document.add(orderParagraph);
        document.add(lineSeparator);
        Map<Product, Integer> productAmount = order.getProductAmount();
        int numberItems = 1;
        for (Map.Entry<Product, Integer> entry : productAmount.entrySet()) {
            Paragraph itemParagraph = new Paragraph(numberItems + ". Назва товару: "
                    + entry.getKey().getName() + " - ("
                    + ProductAmountConverter.convertProductAmount(
                            entry.getKey().getAmountInPackage())
                    + "/упак) - " + entry.getValue() + " шт. ", arialFont);
            itemParagraph.setLeading(30f);
            itemParagraph.setAlignment(Element.ALIGN_LEFT);
            document.add(itemParagraph);
            numberItems++;
        }
        document.add(lineSeparator);
        Paragraph totalSumparagraph = new Paragraph("Сумма замовлення: "
                + order.getSum(), arialFont);
        totalSumparagraph.setLeading(20f);
        totalSumparagraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalSumparagraph);
        Paragraph dateTimeDelivery = new Paragraph("Дата та час доставки: -"
                + order.getDeliveryInformation().getDayOfDelivery() + " - "
                + order.getDeliveryInformation().getTimeOfDelivery(), arialFont);
        dateTimeDelivery.setLeading(20f);
        document.add(dateTimeDelivery);
        Paragraph commentParagraph = new Paragraph("Коментар до замовлення: - "
                + order.getDeliveryInformation().getComment(), arialFont);
        commentParagraph.setLeading(20f);
        document.add(commentParagraph);

        Paragraph endParagraph = new Paragraph("Будемо раді знову вітати Вас у нашому магазині. "
                + "Якщо у вас виникнуть запитання, ви можете зв’язатися з нами за адресою: "
                + "foodsparksmail@gmail.com",
                arialFont);
        endParagraph.setSpacingBefore(80f);
        endParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(endParagraph);
        document.close();

        byte[] pdfBytes = baos.toByteArray();
        String userEmail = order.getUser().getEmail();
        emailService.sendEmailWithDocument(pdfBytes, userEmail);
    }
}
