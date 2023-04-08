package team.project.foodsparks.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserRegistrationEvent extends ApplicationEvent {
    private final Long userId;

    public UserRegistrationEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }
}
