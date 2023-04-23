package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.WarehouseResponseDto;
import team.project.foodsparks.exception.DataProcessingException;
import team.project.foodsparks.model.Warehouse;
import team.project.foodsparks.service.WarehouseService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/warehouses")
@CrossOrigin(origins = "*")
public class WarehouseController {
    private final WarehouseService warehouseService;
    private final ResponseDtoMapper<WarehouseResponseDto, Warehouse> warehouseResponseDtoMapper;

    @Autowired
    public WarehouseController(WarehouseService warehouseService,
                               ResponseDtoMapper<WarehouseResponseDto,
                                       Warehouse> warehouseResponseDtoMapper) {
        this.warehouseService = warehouseService;
        this.warehouseResponseDtoMapper = warehouseResponseDtoMapper;
    }

    @GetMapping
    @ApiOperation(value = "Get all products balances")
    public List<WarehouseResponseDto> getAll() {
        return warehouseService.getAll()
                .stream()
                .map(warehouseResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product balance from warehouse by product id")
    public WarehouseResponseDto getById(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getById(id).orElseThrow(
                () -> new DataProcessingException("Продукта з id: "
                        + id + " не існує."));
        return warehouseResponseDtoMapper.mapToDto(warehouse);
    }

    @PutMapping("/increase")
    @ApiOperation(value = "Increase balance of product in warehouse by ingredient id")
    public WarehouseResponseDto increaseAmountOfIngredient(@RequestParam Long productId,
                                                           @RequestParam Integer amount) {
        Warehouse warehouse = warehouseService.increaseAmountOfProduct(productId, amount);
        return warehouseResponseDtoMapper.mapToDto(warehouse);
    }

    @PutMapping("/decrease")
    @ApiOperation(value = "Decrease balance of product in warehouse by ingredient id")
    public WarehouseResponseDto decreaseAmountOfIngredient(@RequestParam Long productId,
                                                           @RequestParam Integer amount) {
        Warehouse warehouse = warehouseService.decreaseAmountOfProduct(productId, amount);
        return warehouseResponseDtoMapper.mapToDto(warehouse);
    }
}
