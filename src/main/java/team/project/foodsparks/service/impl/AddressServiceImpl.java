package team.project.foodsparks.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.repository.AddressRepository;
import team.project.foodsparks.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> getById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
