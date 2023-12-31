package io.lenra.app;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.lenra.app.component.View;
import io.lenra.app.data.Counter;
import io.lenra.app.request.ViewRequest;
import io.lenra.app.view.CounterView;
import jakarta.inject.Singleton;

@Singleton
public class MyApp extends LenraApplication {
    @Override
    Manifest manifest() {
        var manifest = new Manifest();
        manifest.setJson(new Manifest.Exposer(List.of(
                new Manifest.Route("/counter", new View("counter")))));
        return manifest;
    }

    @Override
    Map<String, Function<?, Object>> views() {
        return Map.of("counter", CounterView::handle, "test", request -> "coucou");
    }

}
