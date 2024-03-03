package io.lenra.app.listener;

import java.util.List;
import java.util.Map;

import io.lenra.api.internal.ApiException;
import io.lenra.app.request.ListenerRequest;

public class IncrementListener {
    public IncrementListener() {
    }

    public static IncrementListener handle(ListenerRequest<Map<String, Object>> request) {
        try {
            List<Map<String, Object>> counters = request.getApi().data().coll("counter").find(request.getProps(),
                    Map.of());
            Map<String, Object> counter = counters.get(0);
            counter.put("count", (double) counter.get("count") + 1);

            request.getApi().data().coll("counter").updateDoc(counter);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return null;
    }
}
