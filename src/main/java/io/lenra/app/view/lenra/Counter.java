package io.lenra.app.view.lenra;

import static io.lenra.api.components.Components.button;
import static io.lenra.api.components.Components.flex;
import static io.lenra.api.components.Components.text;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.api.components.Flex;
import io.lenra.api.components.Flex.CrossAxisAlignment;
import io.lenra.api.components.Flex.MainAxisAlignment;
import io.lenra.api.components.Listener;
import io.lenra.app.annotation.AppView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public class Counter {
  @AppView(prefix = "lenra.")
  public static Flex counter(List<io.lenra.app.data.Counter> counters, Props props) {
    var counter = counters.get(0);
    return flex(
        List.of(text(props.getText() + ": " + counter.getCount()),
            button("+",
                b -> b.setOnPressed(new Listener("increment", Map.of("id", counter.getId()))))),
        f -> {
          f.setSpacing(16d);
          f.setMainAxisAlignment(MainAxisAlignment.SPACE_EVENLY);
          f.setCrossAxisAlignment(CrossAxisAlignment.CENTER);
        });
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Props {
    @NonNull
    private String text;
  }
}
