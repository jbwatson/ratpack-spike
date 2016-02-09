package ratpack.example.java.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.http.client.HttpClient;
import ratpack.http.client.ReceivedResponse;
import rx.Observable;
import rx.functions.Action1;

import java.net.URI;

import static ratpack.rx.RxRatpack.observe;

@Singleton
public class LatencyServiceImpl implements LatencyService {

    private static final String uri = "http://localhost:3000/delayed";

    private final HttpClient httpClient;

    @Inject
    public LatencyServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public Observable<String> getDelayedMsg() {
        return observe(httpClient.get(URI.create(uri))).map(response -> response.getBody().getText());
    }

}
