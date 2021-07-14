package recipes.controller;

import recipes.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeController {

    private Recipe recipe;

    @GetMapping(value = "/api/recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @PostMapping(value = "/api/recipe")
    public void postRecipe(@RequestBody Recipe recipe) {
        this.recipe = recipe;
    }

}
