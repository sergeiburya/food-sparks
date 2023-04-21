package team.project.foodsparks.service.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
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
        BaseFont bf = BaseFont.createFont(FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font arialFont = new Font(bf, 12);

        document.open();
        document.setMargins(72, 36, 36, 36);
        Paragraph titleParagraph = new Paragraph("Thank you for order.\n"
                + "Here are the details of your order.",
                FontFactory.getFont(FontFactory.TIMES, 12));
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        titleParagraph.setLeading(30f);
        document.add(titleParagraph);
        Paragraph orderNumParagraph = new Paragraph("Order Number: FS000" + order.getId(),
                FontFactory.getFont(FontFactory.TIMES_ROMAN, 16));
        orderNumParagraph.setAlignment(Element.ALIGN_CENTER);
        orderNumParagraph.setLeading(30f);
        document.add(orderNumParagraph);
        Paragraph dateParagraph = new Paragraph("Orders Time: " + order.getOrderTime()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")),
                FontFactory.getFont(FontFactory.TIMES_ROMAN));
        dateParagraph.setAlignment(Element.ALIGN_RIGHT);
        dateParagraph.setLeading(30f);
        document.add(dateParagraph);
        DeliveryInformation deliveryInformation = order.getDeliveryInformation();
        Paragraph adrressParagraph = new Paragraph("Delivery addresses: "
                + deliveryInformation.getTown() + ", "
                + deliveryInformation.getStreet() + ", "
                + deliveryInformation.getBuild() + ", "
                + deliveryInformation.getApartment(), FontFactory.getFont(FontFactory.TIMES_ROMAN));
        adrressParagraph.setAlignment(Element.ALIGN_LEFT);
        adrressParagraph.setLeading(30f);
        document.add(adrressParagraph);
        Paragraph userParagraph = new Paragraph("Users Name: " + deliveryInformation.getFirstName()
                + " " + deliveryInformation.getLastName(),
                FontFactory.getFont(FontFactory.TIMES_ROMAN));
        userParagraph.setAlignment(Element.ALIGN_LEFT);
        userParagraph.setLeading(30f);
        document.add(userParagraph);
        Paragraph phoneParagraph = new Paragraph("Users Phone: " + deliveryInformation.getPhone(),
                FontFactory.getFont(FontFactory.TIMES_ROMAN));
        phoneParagraph.setLeading(30f);
        phoneParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(phoneParagraph);
        Paragraph deliveryTimeParagraf = new Paragraph();
        deliveryTimeParagraf.setLeading(30f);
        document.add(deliveryTimeParagraf);
        Paragraph deliveryDayParagraf = new Paragraph();
        deliveryDayParagraf.setLeading(30f);
        document.add(deliveryDayParagraf);
        Paragraph orderParagraph = new Paragraph("Order Items:",
                FontFactory.getFont(FontFactory.HELVETICA));
        orderParagraph.setAlignment(Element.ALIGN_LEFT);
        orderParagraph.setLeading(40f);
        document.add(orderParagraph);
        Map<Product, Integer> productAmount = order.getProductAmount();
        for (Map.Entry<Product, Integer> entry : productAmount.entrySet()) {
            Paragraph itemParagraph = new Paragraph("Product Name: "
                    + entry.getKey().getName()
                    + " - " + entry.getValue() + " - "
                    + ProductAmountConverter.convertProductAmount(entry.getKey().getAmountInPackage()), arialFont);
            itemParagraph.setLeading(30f);
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
        endParagraph.setSpacingBefore(80f);
        endParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(endParagraph);
        document.close();

        byte[] pdfBytes = baos.toByteArray();
        String userEmail = order.getUser().getEmail();
        emailService.sendEmailWithDocument(pdfBytes, userEmail);
    }
}
