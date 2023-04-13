package team.project.foodsparks.service;

import com.lowagie.text.DocumentException;
import team.project.foodsparks.model.Order;

import java.io.OutputStream;

public interface OrderSendUserEmail {
    void sendOrderEmail(Order order) throws DocumentException;
}
