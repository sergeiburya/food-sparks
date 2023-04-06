package team.project.foodsparks.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Map;
import team.project.foodsparks.model.Product;

public class RecipeProductListSerializer extends JsonSerializer<Map<Product, Double>> {
    @Override
    public void serialize(Map<Product, Double> value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        gen.writeStartArray(value);
        for (Map.Entry<Product, Double> entry : value.entrySet()) {
            gen.writeStartObject();
            gen.writeStringField("name", entry.getKey().getName());
            gen.writeNumberField("amount", entry.getValue());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
