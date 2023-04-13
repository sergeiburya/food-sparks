package team.project.foodsparks.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Order;
import team.project.foodsparks.model.ShoppingCart;
import team.project.foodsparks.model.User;
import team.project.foodsparks.repository.OrderRepository;
import team.project.foodsparks.service.OrderSendUserEmail;
import team.project.foodsparks.service.OrderService;
import team.project.foodsparks.service.ShoppingCartService;

import javax.mail.MessagingException;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final OrderSendUserEmail orderSendUserEmail;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService, OrderSendUserEmail orderSendUserEmail) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.orderSendUserEmail = orderSendUserEmail;
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
                .map(e -> e.getKey().getPrice().multiply(BigDecimal.valueOf(e.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        orderRepository.save(order);
        try {
            orderSendUserEmail.sendOrderEmail(order);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrders(User user) {
        return orderRepository.findAll();
    }
}
