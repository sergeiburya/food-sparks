package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.User;

public interface AddressService {
    Address add(Address address);

    Optional<Address> getById(Long id);

    Optional<Address> findByUser(User user);

    void delete(Long id);
}
