package io.lenra.app.view.lenra;

import static io.lenra.api.components.Components.view;
import static io.lenra.api.components.Components.flex;
import java.util.List;
import java.util.Map;
import io.lenra.api.components.Flex.CrossAxisAlignment;
import io.lenra.api.components.Flex.MainAxisAlignment;
import io.lenra.api.components.LenraComponent;
import io.lenra.api.components.styles.Direction;
import io.lenra.api.components.view.definitions.Find;
import io.lenra.app.annotation.AppView;
import io.lenra.app.view.ViewName;

public class Home {
  @AppView(prefix = "lenra.")
  public static LenraComponent home() {
    return flex(List.of(view(ViewName.LENRA_COUNTER.value, v -> {
      v.setFind(new Find("counter", Map.of("user", "@me")));
      v.setProps(new Counter.Props("My personnal counter"));
    }), view(ViewName.LENRA_COUNTER.value, v -> {
      v.setFind(new Find("counter", Map.of("user", "global")));
      v.setProps(new Counter.Props("The common counter"));
    })), f -> {
      f.setDirection(Direction.VERTICAL);
      f.setSpacing(16d);
      f.setMainAxisAlignment(MainAxisAlignment.SPACE_EVENLY);
      f.setCrossAxisAlignment(CrossAxisAlignment.CENTER);
    });
  }
}
