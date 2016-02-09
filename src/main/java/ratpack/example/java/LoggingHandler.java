package ratpack.example.java;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * An example of a handler implicitly set up by a module
 *
 * @see BaseModule
 */
public class LoggingHandler implements Handler {

    @Override
    public void handle(Context context) {
        System.out.println("Received: " + context.getRequest().getUri());
        context.next();
    }
}
