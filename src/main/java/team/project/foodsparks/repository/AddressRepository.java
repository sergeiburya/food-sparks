package team.project.foodsparks.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findById(Long id);

    Optional<Address> findByUser(User user);
}
