package team.project.foodsparks.exeption;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidJwtAuthenticationExceptionHandler {
    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
    public ResponseEntity<Object>
            handleInvalidJwtAuthenticationException(InvalidJwtAuthenticationException e) {
        HttpStatus status = HttpStatus.valueOf(403);
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, HttpStatus.valueOf(403));
    }
}
