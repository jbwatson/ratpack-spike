package ratpack.example.java.model;

import java.util.Map;

public class Content {

    private final Map<String, Object> content;

    public Content(Map<String, Object> content) {
        this.content = content;
    }

    public Map<String, Object> getContent() {
        return content;
    }
}
