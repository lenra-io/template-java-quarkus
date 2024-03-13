package io.lenra.app.view.lenra;

import static io.lenra.api.components.Components.container;
import static io.lenra.api.components.Components.flex;
import static io.lenra.api.components.Components.flexible;
import static io.lenra.api.components.Components.text;
import java.util.List;
import io.lenra.api.components.Flex.CrossAxisAlignment;
import io.lenra.api.components.Flex.MainAxisAlignment;
import io.lenra.api.components.Image;
import io.lenra.api.components.LenraComponent;
import io.lenra.api.components.Text.TextAlign;
import io.lenra.api.components.styles.BoxConstraints;
import io.lenra.api.components.styles.BoxDecoration;
import io.lenra.api.components.styles.BoxShadow;
import io.lenra.api.components.styles.Offset;
import io.lenra.api.components.styles.Padding;
import io.lenra.api.components.styles.TextStyle;
import io.lenra.api.components.styles.TextStyle.FontWeight;
import io.lenra.app.annotation.AppView;

public class Menu {
  @AppView(prefix = "lenra.")
  public static LenraComponent menu() {
    return container(c -> {
        c.setChild(flex(List.of(
            container(c1 -> {
                c1.setChild(new Image("logo.png"));
                c1.setConstraints(BoxConstraints.builder()
                    .minWidth(32d)
                    .maxWidth(32d)
                    .minHeight(32d)
                    .maxHeight(32d)
                    .build());
            }),
            flexible(
                container(c2 -> {
                c2.setChild(text("Hello World", t -> {
                    t.setTextAlign(TextAlign.CENTER);
                    t.setStyle(TextStyle.builder()
                        .fontWeight(FontWeight.BOLD)
                        .fontSize(24d)
                        .build());
                }));
            }))
        ), f -> {
            f.setMainAxisAlignment(MainAxisAlignment.SPACE_BETWEEN);
            f.setCrossAxisAlignment(CrossAxisAlignment.CENTER);
            f.setPadding(Padding.builder()
                .right(32d)
                .build());
        }));
        c.setDecoration(BoxDecoration.builder()
            .color(0xFFFFFFFF)
            .boxShadow(BoxShadow.builder()
                .blurRadius(8d)
                .color(0x1A000000)
                .offset(new Offset(0d, 1d))
                .build())
            .build());
        c.setPadding(Padding.builder()
            .top(16d)
            .bottom(16d)
            .left(32d)
            .right(32d)
            .build());
    });
  }
}
