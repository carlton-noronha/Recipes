package recipes.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.business.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    // Query to find all recipes by a specific category case-insensitive
    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);

    // Query to find all recipes containing the specified name case-insensitive
    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
}