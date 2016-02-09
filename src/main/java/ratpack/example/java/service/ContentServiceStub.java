package ratpack.example.java.service;

import ratpack.example.java.handler.ContentRequestHandler;
import ratpack.example.java.model.Content;

import java.util.HashMap;
import java.util.Map;

/**
 * The service implementation.
 *
 * @see ContentRequestHandler
 */
public class ContentServiceStub implements ContentService {

    public Content getContent() {
        Map<String, Object> content = new HashMap<>();
        content.put("terms", "blah blah blah");
        content.put("price", 17.50);
        return new Content(content);
    }

}
