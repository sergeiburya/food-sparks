package team.project.foodsparks.repository.specification;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.Recipe;

@Component
public class RecipeSpecificationManager implements SpecificationManager<Recipe> {
    private final Map<String, SpecificationProvider<Recipe>> providersMap;

    @Autowired
    public RecipeSpecificationManager(List<SpecificationProvider<Recipe>> providersList) {
        this.providersMap = providersList
                .stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey,
                        Function.identity()));
    }

    @Override
    public Specification<Recipe> get(String filterKey, String[] params) {
        if (!providersMap.containsKey(filterKey)) {
            throw new RuntimeException("Filter key does not exist");
        }
        return providersMap.get(filterKey).getSpecification(params);
    }
}
