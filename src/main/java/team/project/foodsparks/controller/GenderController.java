package team.project.foodsparks.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.project.foodsparks.dto.response.GenderResponseDto;
import team.project.foodsparks.model.Gender;
import team.project.foodsparks.service.GenderService;
import team.project.foodsparks.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/gender")
@CrossOrigin(origins = "*")
public class GenderController {
    private final GenderService genderService;
    private final ResponseDtoMapper<GenderResponseDto, Gender> genderResponseDtoMapper;

    @Autowired
    public GenderController(GenderService genderService,
                            ResponseDtoMapper<GenderResponseDto,
                                    Gender> genderResponseDtoMapper) {
        this.genderService = genderService;
        this.genderResponseDtoMapper = genderResponseDtoMapper;
    }

    @GetMapping
    @ApiOperation(value = "")
    public List<GenderResponseDto> getAllGenders() {
        List<Gender> genderServiceAll = genderService.getAll();
        return genderServiceAll
                .stream()
                .map(genderResponseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
