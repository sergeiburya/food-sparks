package team.project.foodsparks.service;

import java.util.Optional;
import team.project.foodsparks.model.Address;

public interface AddressService {
    Address add(Address address);

    Optional<Address> getById(Long id);

    void delete(Long id);
}
