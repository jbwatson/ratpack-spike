package ratpack.example.java;

import ratpack.example.java.handler.ContentRequestHandler;
import ratpack.example.java.handler.LatencyRequestHandler;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.rx.RxRatpack;

public class MyApp {

  public static void main(String[] args) throws Exception {
    RxRatpack.initialize();
    RatpackServer.start(s -> s
        .serverConfig(c -> c.baseDir(BaseDir.find()))
        .registry(Guice.registry(b -> b.module(BaseModule.class)))
        .handlers(chain -> chain
            .path("content", ContentRequestHandler.class)
            .path("slow", LatencyRequestHandler.class)
            .all(ctx -> ctx.render("root handler!"))
        )
    );
  }
}
