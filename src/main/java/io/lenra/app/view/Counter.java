package io.lenra.app.view;

import static io.lenra.api.components.Components.listener;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.api.components.Listener;
import io.lenra.app.annotation.AppView;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Counter {
  @AppView
  public static CounterView counter(List<io.lenra.app.data.Counter> counters) {
    var counter = counters.get(0);
    return new CounterView(counter.getCount(),
        listener("increment", l -> l.setProps(Map.of("_id", counter.getId()))));
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Data
  @AllArgsConstructor
  public static class CounterView {
    private int value;
    private Listener onIncrement;
  }

}
