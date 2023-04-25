package team.project.foodsparks.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import team.project.foodsparks.model.CartItem;
import team.project.foodsparks.util.ProductAmountConverter;

public class ShoppingCartProductMapSerializer
        extends JsonSerializer<List<CartItem>> {
    @Override
    public void serialize(List<CartItem> value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeStartArray(value);
        for (CartItem cartItem : value) {
            gen.writeStartObject();
            gen.writeNumberField("productId", cartItem.getProduct().getId());
            gen.writeStringField("name", cartItem.getProduct().getName());
            gen.writeNumberField("quantity", cartItem.getQuantity());
            gen.writeStringField("quantityInPackages",
                    ProductAmountConverter.convertProductAmount(cartItem.getQuantity()
                            * cartItem.getProduct().getAmountInPackage()));
            gen.writeNumberField("productSum", cartItem.getProduct().getPrice()
                    .multiply(BigDecimal.valueOf(cartItem.getQuantity())));
            gen.writeStringField("imageUrl", cartItem.getProduct().getImageUrl());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
