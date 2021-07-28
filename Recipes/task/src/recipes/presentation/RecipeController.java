package recipes.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.business.Message;
import recipes.business.Recipe;
import recipes.business.RecipeService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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

    @GetMapping(value = "/api/recipe/search")
    public List<Recipe> getRecipes(@RequestParam Map<String,String> requestParams) {
        int size = requestParams.size();
        if (size == 1) {
            if (requestParams.containsKey("category")) {
                return recipeService.findByCategoryIgnoreCaseOrderByDateDesc(requestParams.get("category"));
            } else if (requestParams.containsKey("name")) {
                return recipeService.findByNameContainingIgnoreCaseOrderByDateDesc(requestParams.get("name"));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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

    @PutMapping(value = "/api/recipe/{id}")
    public void updateRecipe(@PathVariable long id, @Valid @RequestBody Recipe recipe) {
        Optional<Recipe> identifiedRecipe = recipeService.findById(id);
        if (identifiedRecipe.isPresent()) {
            recipe.setId(id);
            recipe.setDate(LocalDateTime.now());
            recipeService.save(recipe);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found!");
        }
    }

}
