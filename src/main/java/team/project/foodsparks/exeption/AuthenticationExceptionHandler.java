package team.project.foodsparks.exeption;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthenticationExceptionHandler {

    @ExceptionHandler(value = {AuthenticationException.class})
    public ResponseEntity<Object> handleAuthenticationException(AuthenticationException e) {
        ApiException exception = new ApiException(
                e.getMessage(),
                HttpStatus.UNAUTHORIZED,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, HttpStatus.valueOf(401));
    }
}
