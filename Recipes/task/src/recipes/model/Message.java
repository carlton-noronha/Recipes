package recipes.model;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Message {
    public int id;

    Message() {
        id = 0;
    }

}
