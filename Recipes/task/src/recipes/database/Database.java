package recipes.database;

import lombok.Getter;
import org.springframework.stereotype.Component;
import recipes.model.Recipe;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class Database {
    private Map<Integer, Recipe> storage;

    Database() {
        storage = new HashMap<>();
    }
}
