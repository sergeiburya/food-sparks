package team.project.foodsparks.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
