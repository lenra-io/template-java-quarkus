package io.lenra.app.listener;

import java.util.List;
import java.util.Map;

import io.lenra.api.internal.ApiException;
import io.lenra.app.annotation.AppListener;
import io.lenra.app.api.Api;

public class Increment {
    @AppListener
    public static void increment(Map<String, Object> props, Api api) {
        try {
            List<Map<String, Object>> counters = api.data().coll("counter").find(props, Map.of());
            Map<String, Object> counter = counters.get(0);
            counter.put("count", (double) counter.get("count") + 1);

            api.data().coll("counter").updateDoc(counter);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
