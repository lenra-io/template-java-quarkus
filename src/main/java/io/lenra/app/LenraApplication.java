package io.lenra.app;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import io.lenra.app.request.ViewRequest;

public abstract class LenraApplication {
    private final Manifest manifest;
    private final Map<String, Function<ViewRequest, Object>> views;

    public LenraApplication() {
        this.manifest = manifest();
        this.views = Collections.unmodifiableMap(views());
    }

    public Manifest getManifest() {
        return manifest;
    }

    public Map<String, Function<ViewRequest, Object>> getViews() {
        return views;
    }

    abstract Manifest manifest();
    abstract Map<String, Function<ViewRequest, Object>> views();
}
