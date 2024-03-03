package io.lenra.app.view;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.lenra.api.components.Listener;
import io.lenra.app.data.Counter;
import io.lenra.app.request.ViewRequest;

// TODO: define it glabally: https://www.baeldung.com/jackson-ignore-null-fields#globally
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CounterView {
    private int value;
    private Listener onIncrement;

    public CounterView() {
    }

    public CounterView(int value, Listener onIncrement) {
        this.value = value;
        this.onIncrement = onIncrement;
    }

    public int getValue() {
        return value;
    }

    public Listener getOnIncrement() {
        return onIncrement;
    }

    public static CounterView handle(ViewRequest<List<Counter>, Map<String, Object>> request) {
        List<Counter> counters = request.getData();
        Counter counter = counters.get(0);
        return new CounterView(counter.getCount(), Listener.builder()
                .name("increment")
                .props(Map.of("_id", counter.getId()))
                .build());
    }
}
