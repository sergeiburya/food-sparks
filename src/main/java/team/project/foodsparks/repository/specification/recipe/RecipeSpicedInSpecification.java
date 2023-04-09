package team.project.foodsparks.repository.specification.recipe;

import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.repository.specification.SpecificationProvider;

@Component
public class RecipeSpicedInSpecification
        implements SpecificationProvider<Recipe> {
    private static final String FILTER_KEY = "spicedIn";
    private static final String FIELD_NAME = "spiced";

    @Override
    public Specification<Recipe> getSpecification(String[] spiced) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<Boolean> predicate = cb.in(root.get(FIELD_NAME));
            for (String value : spiced) {
                predicate.value(Boolean.valueOf(value));
            }
            return cb.and(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
