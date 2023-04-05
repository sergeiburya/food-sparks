package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.request.AddressRequestDto;
import team.project.foodsparks.dto.response.AddressResponseDto;
import team.project.foodsparks.model.Address;
import team.project.foodsparks.model.User;
import team.project.foodsparks.service.AddressService;
import team.project.foodsparks.service.UserService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/address")
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

    @PostMapping("/add-address")
    @ApiOperation(value = "Add new Address")
    public AddressResponseDto addAddress(@RequestParam String email,
                                         @RequestBody AddressRequestDto addressRequestDto) {
        Address address = new Address();
        address.setRegion(addressRequestDto.getRegion());
        address.setTown(addressRequestDto.getTown());
        address.setStreet(addressRequestDto.getStreet());
        address.setBuild(addressRequestDto.getBuild());
        address.setApartment(addressRequestDto.getApartment());
        addressService.add(address);
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        user.setAddress(address);
        userService.add(user);
        return addressResponseDtoMapper.mapToDto(address);
    }
}
