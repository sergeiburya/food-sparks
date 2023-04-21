package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.project.foodsparks.model.DeliveryInformation;

public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformation, Long> {
}
