package team.project.foodsparks.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String email;
    private List<Long> roleId;
}
