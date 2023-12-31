package io.lenra.app.component;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Listener {
    @JsonProperty("_type")
    private final String type = "listener";
    private String name;
    private Map<String, Object> props;

    public Listener() {
    }

    public Listener(String name) {
        this.name = name;
    }

    public Listener(String name, Map<String, Object> props) {
        this.name = name;
        this.props = props;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getProps() {
        return props;
    }
}
