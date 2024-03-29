package team.project.foodsparks.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long id;
    private Map<String, Integer> productAmount;
    private DeliveryInformationResponseDto deliveryInformationResponseDto;
    private Long userId;
    private LocalDateTime orderTime;
    private BigDecimal sum;
}
