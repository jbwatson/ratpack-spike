package ratpack.example.java.service;

import ratpack.example.java.handler.ContentRequestHandler;
import ratpack.example.java.model.Content;

/**
 * An example service interface.
 *
 * @see ContentRequestHandler
 */
public interface ContentService {

    Content getContent();

}
