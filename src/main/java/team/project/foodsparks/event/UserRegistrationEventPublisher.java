package team.project.foodsparks.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserRegistrationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Async
    public void publishUserRegistrationEvent(Long userId) {
        UserRegistrationEvent userRegistrationEvent = new UserRegistrationEvent(this, userId);
        applicationEventPublisher.publishEvent(userRegistrationEvent);
    }
}
