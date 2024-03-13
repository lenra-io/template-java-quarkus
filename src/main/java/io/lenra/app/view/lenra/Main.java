package io.lenra.app.view.lenra;

import static io.lenra.api.components.Components.flex;
import static io.lenra.api.components.Components.view;
import java.util.List;
import io.lenra.api.components.Flex.CrossAxisAlignment;
import io.lenra.api.components.LenraComponent;
import io.lenra.api.components.styles.Direction;
import io.lenra.app.annotation.AppView;
import io.lenra.app.view.ViewName;

public class Main {
  @AppView(prefix = "lenra.")
  public static LenraComponent main() {
    return flex(List.of(
            view(ViewName.LENRA_MENU.value),
            view(ViewName.LENRA_HOME.value)
            ),
        f -> {
          f.setDirection(Direction.VERTICAL);
          f.setScroll(true);
          f.setSpacing(4d);
          f.setCrossAxisAlignment(CrossAxisAlignment.CENTER);
        }
    );
  }
}
