package team.project.foodsparks.service.mapper;

import org.springframework.stereotype.Component;
import team.project.foodsparks.dto.response.WarehouseResponseDto;
import team.project.foodsparks.model.Warehouse;

@Component
public class WarehouseMapper implements ResponseDtoMapper<WarehouseResponseDto, Warehouse> {
    @Override
    public WarehouseResponseDto mapToDto(Warehouse warehouse) {
        WarehouseResponseDto warehouseResponseDto = new WarehouseResponseDto();
        warehouseResponseDto.setProductName(warehouse.getProduct().getName());
        warehouseResponseDto.setAmount(warehouse.getAmount());
        return warehouseResponseDto;
    }
}
