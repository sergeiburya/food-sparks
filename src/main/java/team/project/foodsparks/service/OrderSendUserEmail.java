package team.project.foodsparks.service;

import com.lowagie.text.DocumentException;
import team.project.foodsparks.model.Order;

public interface OrderSendUserEmail {
    void sendOrderEmail(Order order) throws DocumentException;
}
