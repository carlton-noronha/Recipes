package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.business.Message;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;
import java.util.Optional;


@RestController
public class RecipeController {

    @Autowired
    private Message message;

    @Autowired
    private RecipeService recipeService;

    @GetMapping(value = "/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()) {
            return recipe.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found!");
        }
    }

    @DeleteMapping(value = "/api/recipe/{id}")
    public Recipe deleteRecipe(@PathVariable long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()) {
            recipeService.deleteById(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found!");
        }
    }

    @PostMapping(value = "/api/recipe/new")
    public Message postRecipe(@Valid @RequestBody Recipe recipe) {
        message.id = recipeService.save(recipe).getId();
        return message;
    }

}
