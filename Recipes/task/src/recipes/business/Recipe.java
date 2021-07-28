package recipes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
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

    @NotBlank(message = "What type of recipe is this ?")
    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDateTime date;

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

    public Recipe() {
        this.date = LocalDateTime.now();
    }

    public Recipe(String name, String category,
                  String description,
                  List<@NotBlank String> ingredients,
                  List<@NotBlank String> directions) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.date = LocalDateTime.now();
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
