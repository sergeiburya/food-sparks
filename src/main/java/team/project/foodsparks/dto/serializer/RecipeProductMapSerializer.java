package team.project.foodsparks.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;
import team.project.foodsparks.dto.response.ProductResponseDto;
import team.project.foodsparks.util.ProductAmountConverter;

public class RecipeProductMapSerializer extends JsonSerializer<Map<ProductResponseDto, Integer>> {
    @Override
    public void serialize(Map<ProductResponseDto, Integer> value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeStartArray(value);
        for (Map.Entry<ProductResponseDto, Integer> entry : value.entrySet()) {
            gen.writeStartObject();
            gen.writeNumberField("productId", entry.getKey().getId());
            gen.writeStringField("name", entry.getKey().getName());
            gen.writeStringField("amount", ProductAmountConverter
                    .convertProductAmount(entry.getValue()));
            gen.writeNumberField("price", entry.getKey().getPrice());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
