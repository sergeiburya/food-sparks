package team.project.foodsparks.exeption;

public class InvalidJwtAuthenticationException extends RuntimeException {

    public InvalidJwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
