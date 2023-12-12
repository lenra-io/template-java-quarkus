package io.lenra.app.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Data {
    @JsonProperty("_id")
    private String id;

    public Data() {
    }

    public Data(String id) {
        this.id = id;
    }
}
