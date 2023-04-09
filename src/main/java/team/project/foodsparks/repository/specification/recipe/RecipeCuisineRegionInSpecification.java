package team.project.foodsparks.repository.specification.recipe;

import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.repository.specification.SpecificationProvider;

@Component
public class RecipeCuisineRegionInSpecification
        implements SpecificationProvider<Recipe> {
    private static final String FILTER_KEY = "cuisineRegionIn";
    private static final String FIELD_NAME = "cuisineRegion";

    @Override
    public Specification<Recipe> getSpecification(String[] cuisineRegions) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Long> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : cuisineRegions) {
                predicate.value(Long.valueOf(value));
            }
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
