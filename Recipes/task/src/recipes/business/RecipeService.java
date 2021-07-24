package recipes.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.persistence.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe save(Recipe toSave) {
        return recipeRepository.save(toSave);
    }

    public Optional<Recipe> findById(long id) {
        return recipeRepository.findById(id);
    }

    public void deleteById(long id) {
        recipeRepository.deleteById(id);
    }
}
