package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.AddressRequestDto;
import team.project.foodsparks.dto.response.AddressResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.AddressService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {
    private final AddressService addressService;
    private final UserService userService;
    private final ResponseDtoMapper<AddressResponseDto, Address> addressResponseDtoMapper;

    @Autowired
    public AddressController(AddressService addressService,
                             UserService userService, ResponseDtoMapper<AddressResponseDto,
                                     Address> addressResponseDtoMapper) {
        this.addressService = addressService;
        this.userService = userService;
        this.addressResponseDtoMapper = addressResponseDtoMapper;
    }

    @PutMapping("/add")
    @ApiOperation(value = "Add new Address has user Role")
    public AddressResponseDto addAddress(Authentication auth,
                                         @RequestBody AddressRequestDto addressRequestDto) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).get();
        Address address = addressService.findByUser(user).orElse(new Address());
        address.setRegion(addressRequestDto.getRegion());
        address.setTown(addressRequestDto.getTown());
        address.setStreet(addressRequestDto.getStreet());
        address.setBuild(addressRequestDto.getBuild());
        address.setApartment(addressRequestDto.getApartment());
        address.setUser(user);
        addressService.add(address);
        return addressResponseDtoMapper.mapToDto(address);
    }

    @GetMapping("/by-user")
    @ApiOperation(value = "Get Address By User")
    public AddressResponseDto getAddressByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        Address address = addressService.findByUser(user)
                .orElseThrow(() -> new DataProcessingException(
                        "Address by User " + user.getEmail() + " not found."));
        return addressResponseDtoMapper.mapToDto(address);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete Address User has user Role")
    @Transactional
    public void deleteByEmail(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        addressService.deleteByEmail(email);
    }
}
