package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.request.DeliveryInformationRequestDto;
import team.project.foodsparks.dto.response.DeliveryInformationResponseDto;
import team.project.foodsparks.model.DeliveryInformation;

@Component
public class DeliveryInformationMapper
        implements RequestDtoMapper<DeliveryInformationRequestDto, DeliveryInformation>,
        ResponseDtoMapper<DeliveryInformationResponseDto, DeliveryInformation> {
    @Override
    public DeliveryInformation mapToModel(DeliveryInformationRequestDto dto) {
        DeliveryInformation deliveryInformation = new DeliveryInformation();
        deliveryInformation.setFirstName(dto.getFirstName());
        deliveryInformation.setLastName(dto.getLastName());
        deliveryInformation.setPhone(dto.getPhone());
        deliveryInformation.setTown(dto.getTown());
        deliveryInformation.setStreet(dto.getStreet());
        deliveryInformation.setBuild(dto.getBuild());
        deliveryInformation.setApartment(dto.getApartment());
        deliveryInformation.setDayOfDelivery(dto.getDayOfDelivery());
        deliveryInformation.setTimeOfDelivery(dto.getTimeOfDelivery());
        deliveryInformation.setComment(dto.getComment());
        return deliveryInformation;
    }

    @Override
    public DeliveryInformationResponseDto mapToDto(DeliveryInformation deliveryInformation) {
        DeliveryInformationResponseDto dto = new DeliveryInformationResponseDto();
        dto.setId(deliveryInformation.getId());
        dto.setFirstName(deliveryInformation.getFirstName());
        dto.setLastName(deliveryInformation.getLastName());
        dto.setPhone(deliveryInformation.getPhone());
        dto.setTown(deliveryInformation.getTown());
        dto.setStreet(deliveryInformation.getStreet());
        dto.setBuild(deliveryInformation.getBuild());
        dto.setApartment(deliveryInformation.getApartment());
        dto.setComment(deliveryInformation.getComment());
        dto.setDayOfDelivery(deliveryInformation.getDayOfDelivery());
        dto.setTimeOfDelivery(deliveryInformation.getTimeOfDelivery());
        return dto;
    }
}
