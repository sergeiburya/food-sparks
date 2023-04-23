package team.project.foodsparks.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataProcessingExceptionHandler {
    @ExceptionHandler(value = {DataProcessingException.class})
    public ResponseEntity<Object> handleDataProcessingException(DataProcessingException e) {
        HttpStatus status = HttpStatus.valueOf(404);
        ApiException exception = new ApiException(
                e.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exception, status);
    }
}
