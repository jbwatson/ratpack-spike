package ratpack.example.java.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.example.java.service.LatencyService;
import ratpack.handling.Context;
import ratpack.handling.Handler;

@Singleton
public class LatencyRequestHandler implements Handler {

    private final LatencyService latencyService;

    @Inject
    public LatencyRequestHandler(LatencyService latencyService) {
        this.latencyService = latencyService;
    }


    @Override
    public void handle(Context ctx) throws Exception {
        latencyService.getDelayedMsg().subscribe(ctx::render);
    }
}
