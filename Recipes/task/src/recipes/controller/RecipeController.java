package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.database.Database;
import recipes.model.Message;
import recipes.model.Recipe;


@RestController
public class RecipeController {

    @Autowired
    private Database database;

    @Autowired
    private Message message;

    @GetMapping(value = "/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        if (database.getStorage().containsKey(id)) {
            return database.getStorage().get(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/api/recipe/new")
    public Message postRecipe(@RequestBody Recipe recipe) {
        int id =  message.id + 1;
        database.getStorage().put(id, recipe);
        System.out.println(database.getStorage());
        message.id = id;
        return message;
    }

}
