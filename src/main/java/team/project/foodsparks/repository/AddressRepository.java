package team.project.foodsparks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
