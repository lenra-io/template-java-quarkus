package io.lenra.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.lenra.app.LenraApplication;

// @Data
public class ViewRequest<D, P> extends AppRequest<Object> {
    @JsonProperty(required = true)
    private String view;
    private D data;
    private P props;

    public ViewRequest() {
    }

    public ViewRequest(String name) {
        this.view = name;
    }

    public ViewRequest(String name, D data) {
        this.view = name;
        this.data = data;
    }

    public ViewRequest(String name, D data, P props) {
        this.view = name;
        this.data = data;
        this.props = props;
    }

    public String getView() {
        return view;
    }

    public ViewRequest<D, P> data(D data) {
        this.data = data;
        return this;
    }

    public D getData() {
        return data;
    }

    public ViewRequest<D, P> props(P props) {
        this.props = props;
        return this;
    }

    public P getProps() {
        return props;
    }

    @Override
    public Object handle(LenraApplication application) {
        var view = application.getViews().get(this.getView());
        return view.apply(this);
    }
}
