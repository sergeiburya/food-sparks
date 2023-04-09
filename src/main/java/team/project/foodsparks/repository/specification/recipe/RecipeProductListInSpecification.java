package team.project.foodsparks.repository.specification.recipe;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.MapJoin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import team.project.foodsparks.model.Recipe;
import team.project.foodsparks.repository.specification.SpecificationProvider;

@Component
public class RecipeProductListInSpecification
        implements SpecificationProvider<Recipe> {
    private static final String FILTER_KEY = "productListIn";

    @Override
    public Specification<Recipe> getSpecification(String[] products) {
        return (root, query, cb) -> {
            MapJoin<Recipe, Long, Double> recipes = root.joinMap("productList");
            CriteriaBuilder.In<Long> predicate = cb.in(recipes.key());
            for (String value : products) {
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
