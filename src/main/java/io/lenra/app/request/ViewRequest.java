package io.lenra.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.lenra.app.LenraApplication;

// @Data
public class ViewRequest extends AppRequest<Object> {
    @JsonProperty(required = true)
    private String view;

    public ViewRequest() {
    }

    public ViewRequest(String name) {
        this.view = name;
    }

    public String getView() {
        return view;
    }

    @Override
    public Object handle(LenraApplication application) {
        var view = application.getViews().get(this.getView());
        return view.apply(this);
    }
}
