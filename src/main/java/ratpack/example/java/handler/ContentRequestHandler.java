package ratpack.example.java.handler;

import ratpack.example.java.BaseModule;
import ratpack.example.java.model.Content;
import ratpack.example.java.service.ContentService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import javax.inject.Inject;
import javax.inject.Singleton;

import static ratpack.jackson.Jackson.json;

/**
 * A handler implementation that is created via dependency injection.
 *
 * @see BaseModule
 */
@Singleton
public class ContentRequestHandler implements Handler {

  private final ContentService contentService;

  @Inject
  public ContentRequestHandler(ContentService contentService) {
    this.contentService = contentService;
  }

  @Override
  public void handle(Context context) {
    Content content = contentService.getContent();
    context.render(json(content));
  }
}
