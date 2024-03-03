package io.lenra.app;

import java.util.List;
import java.util.Map;

import io.lenra.api.Exposer;
import io.lenra.api.Manifest;
import io.lenra.api.Route;
import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;
import io.lenra.api.internal.ApiException;
import io.lenra.app.api.Collection;
import io.lenra.app.handlers.ListenerHandler;
import io.lenra.app.handlers.ViewHandler;
import io.lenra.app.listener.IncrementListener;
import io.lenra.app.request.ListenerRequest;
import io.lenra.app.view.CounterView;
import jakarta.inject.Singleton;

@Singleton
public class MyApp extends LenraApplication {
    @Override
    protected Manifest manifest() {
        return Manifest.builder()
                .json(Exposer.builder()
                        .route(Route.builder()
                                .path("/counter/global")
                                .view(View.builder()
                                        .name("counter")
                                        .find(Find.builder()
                                                .coll("counter")
                                                .query(Map.of("user", "global"))
                                                .build())
                                        .build())
                                .role("guest")
                                .role("user")
                                .build())
                        .route(Route.builder()
                                .path("/counter/me")
                                .view(View.builder()
                                        .name("counter")
                                        .find(Find.builder()
                                                .coll("counter")
                                                .query(Map.of("user", "@me"))
                                                .build())
                                        .build())
                                .build())
                        .build())
                .build();
    }

    @Override
    protected Map<String, ViewHandler<?, ?>> views() {
        return Map.of(
                "counter", new ViewHandler<>(CounterView::handle) {
                },
                "lenra.counter", new ViewHandler<>(CounterView::handle) {
                });
    }

    @Override
    protected Map<String, ListenerHandler<?>> listeners() {
        return Map.of(
                "increment", new ListenerHandler<>(IncrementListener::handle) {
                },
                "onEnvStart", new ListenerHandler<>((ListenerRequest<Object> props) -> {
                    try {
                        createCounter(props, "global");
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                    return null;
                }) {
                },
                "onUserFirstJoin", new ListenerHandler<>((ListenerRequest<Object> props) -> {
                    try {
                        createCounter(props, "@me");
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                    return null;
                }) {
                },
                "onSessionStart", new ListenerHandler<>((ListenerRequest<Object> props) -> null) {
                });
    }

    void createCounter(ListenerRequest<Object> request, String user) throws ApiException {
        Collection counterColl = request.getApi().data().coll("counter");
        List<Map<String, Object>> counters = counterColl.find(Map.of("user", user), Map.of());

        if (counters.size() == 0) {
            counterColl.createDoc(new io.lenra.app.data.Counter(user, 0));
        }
    }
}
