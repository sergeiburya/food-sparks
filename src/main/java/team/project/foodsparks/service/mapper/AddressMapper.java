package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.AddressRequestDto;
import team.project.foodsparks.dto.response.AddressResponseDto;
import team.project.foodsparks.model.Address;

@Component
public class AddressMapper implements
        RequestDtoMapper<AddressRequestDto, Address>,
        ResponseDtoMapper<AddressResponseDto, Address> {
    @Override
    public Address mapToModel(AddressRequestDto dto) {
        Address address = new Address();
        address.setRegion(dto.getRegion());
        address.setTown(dto.getTown());
        address.setStreet(dto.getStreet());
        address.setBuild(dto.getBuild());
        address.setApartment(dto.getApartment());
        return address;
    }

    @Override
    public AddressResponseDto mapToDto(Address address) {
        AddressResponseDto responseDto = new AddressResponseDto();
        responseDto.setId(address.getId());
        responseDto.setRegion(address.getRegion());
        responseDto.setTown(address.getTown());
        responseDto.setStreet(address.getStreet());
        responseDto.setBuild(address.getBuild());
        responseDto.setApartment(address.getApartment());
        responseDto.setUserId(address.getUser().getId());
        return responseDto;
    }
}
