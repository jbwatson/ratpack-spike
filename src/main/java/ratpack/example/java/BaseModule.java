package ratpack.example.java;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import ratpack.example.java.handler.ContentRequestHandler;
import ratpack.example.java.handler.LatencyRequestHandler;
import ratpack.example.java.service.ContentService;
import ratpack.example.java.service.ContentServiceStub;
import ratpack.example.java.service.LatencyService;
import ratpack.example.java.service.LatencyServiceImpl;
import ratpack.handling.HandlerDecorator;

/**
 * An example Guice module.
 */
public class BaseModule extends AbstractModule {

  /**
   * Adds a service impl to the application, and registers a decorator so that all requests are logged.
   * Registered implementations of {@link ratpack.handling.HandlerDecorator} are able to decorate the application handler.
   *
   * @see ContentRequestHandler
   */
  protected void configure() {
    bind(ContentService.class).to(ContentServiceStub.class);
    bind(LatencyService.class).to(LatencyServiceImpl.class);
    bind(LatencyRequestHandler.class);
    bind(ContentRequestHandler.class);
    Multibinder.newSetBinder(binder(), HandlerDecorator.class).addBinding().toInstance(HandlerDecorator.prepend(new LoggingHandler()));
  }
}
