package recipes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Recipe")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    @NotBlank(message = "Are you kidding me ? A recipe should have a name")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "You gotta be serious! A recipe should have a description")
    @Column(name = "description")
    private String description;

    @NotNull
    @Size(min = 1, message = "That's strange, your recipe has no ingredients")
    @ElementCollection
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient")
    private List<@NotBlank String> ingredients;

    @NotNull
    @Size(min = 1, message = "Come on!!! Where are the directions for cooking ?")
    @ElementCollection
    @CollectionTable(name = "directions", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "direction")
    private List<@NotBlank String> directions;

    public Recipe() { }

    public Recipe(String name, String description,
                  List<@NotBlank String> ingredients,
                  List<@NotBlank String> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }
}
