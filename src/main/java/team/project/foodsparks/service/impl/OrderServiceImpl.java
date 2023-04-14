package team.project.foodsparks.service.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.exeption.DataProcessingException;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.Product;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.repository.OrderRepository;
import team.project.foodsparks.service.AddressService;
import team.project.foodsparks.service.EmailService;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final EmailService emailService;
    private final AddressService addressService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            EmailService emailService,
                            AddressService addressService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.emailService = emailService;
        this.addressService = addressService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setProductAmount(new HashMap<>(shoppingCart.getProductAmount()));
        order.setUser(shoppingCart.getUser());
        order.setSum(shoppingCart.getProductAmount()
                .entrySet()
                .stream()
                .map(e -> e.getKey().getPrice()
                        .multiply(BigDecimal.valueOf(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        orderRepository.save(order);
        try {
            createAndSendPdfOrderForUser(order);
        } catch (DocumentException e) {
            throw new DataProcessingException("A message with an order cant be sent.",e);
        }
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrders(User user) {
        return orderRepository.findAll();
    }

    @Override
    public void createAndSendPdfOrderForUser(Order order) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

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
        User user = order.getUser();
        Address userAddress = addressService.findByUser(user).orElseThrow(
                () -> new RuntimeException("Address with user " + user + "not found"));
        Paragraph adrressParagraph = new Paragraph("Delivery addresses: "
                + userAddress.getRegion() + ", "
                + userAddress.getTown() + ", "
                + userAddress.getStreet() + ", "
                + userAddress.getBuild() + ", "
                + userAddress.getApartment(), FontFactory.getFont(FontFactory.TIMES_ROMAN));
        adrressParagraph.setAlignment(Element.ALIGN_LEFT);
        adrressParagraph.setLeading(30f);
        document.add(adrressParagraph);
        Paragraph userParagraph = new Paragraph("Users Name: " + user.getFirstName()
                + " " + user.getLastName(), FontFactory.getFont(FontFactory.TIMES_ROMAN));
        userParagraph.setAlignment(Element.ALIGN_LEFT);
        userParagraph.setLeading(30f);
        document.add(userParagraph);
        Paragraph phoneParagraph = new Paragraph("Users Phone: " + user.getPhone(),
                FontFactory.getFont(FontFactory.TIMES_ROMAN));
        phoneParagraph.setLeading(30f);
        phoneParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(phoneParagraph);
        Paragraph orderParagraph = new Paragraph("Order Items:",
                FontFactory.getFont(FontFactory.HELVETICA));
        orderParagraph.setAlignment(Element.ALIGN_LEFT);
        orderParagraph.setLeading(40f);
        document.add(orderParagraph);
        Map<Product, Integer> productAmount = order.getProductAmount();
        for (Map.Entry<Product, Integer> entry : productAmount.entrySet()) {
            Paragraph itemParagraph = new Paragraph("Product Name: "
                    + entry.getKey().getName().toUpperCase()
                    + " - " + entry.getValue());
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
