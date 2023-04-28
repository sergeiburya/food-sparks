package team.project.foodsparks.service;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.util.List;
import javax.mail.MessagingException;
import team.project.foodsparks.model.DeliveryInformation;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart, DeliveryInformation deliveryInformation);

    List<Order> getOrders(User user);

    void createAndSendPdfOrderForUser(Order order)
            throws DocumentException, IOException, MessagingException;
}
