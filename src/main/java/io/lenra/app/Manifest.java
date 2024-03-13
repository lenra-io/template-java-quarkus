package io.lenra.app;

import java.util.List;
import java.util.Map;
import io.lenra.api.Exposer;
import io.lenra.api.Route;
import io.lenra.api.components.View;
import io.lenra.api.components.view.definitions.Find;
import io.lenra.app.annotation.AppManifest;

@AppManifest
public class Manifest extends io.lenra.api.Manifest {
	public Manifest() {
		setJson(new Exposer(null, List.of(
				new Route("/counter/global",
						new View("counter") {
							{
								setFind(new Find("counter", Map.of("user", "global")));
							}
						},
						List.of("guest", "user")),
				new Route("/counter/me",
						new View("counter") {
							{
								setFind(new Find("counter", Map.of("user", "@me")));
							}
						}))));
	}
}
