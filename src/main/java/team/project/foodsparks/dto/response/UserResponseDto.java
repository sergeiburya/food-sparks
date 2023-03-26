package team.project.foodsparks.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String email;
    private List<Long> roleId;
}
