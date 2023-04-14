package team.project.foodsparks.service;

import com.lowagie.text.DocumentException;
import java.util.List;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrders(User user);

    void createAndSendPdfOrderForUser(Order order) throws DocumentException;
}
