package team.project.foodsparks.exception;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

    public ApiException(String message,
                        HttpStatus httpStatus,
                        LocalDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
