package ratpack.example.java.service;

import rx.Observable;

public interface LatencyService {
    Observable<String> getDelayedMsg();
}
