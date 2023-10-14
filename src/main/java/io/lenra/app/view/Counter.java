package io.lenra.app.view;

import io.lenra.app.component.Listener;
import io.lenra.app.request.ViewRequest;

public class Counter {
    public static CounterView handle(ViewRequest request) {
        return new CounterView(0, new Listener("onIncrement"));
    }

    public static class CounterView {
        private int count;
        private Listener onIncrement;

        public CounterView() {
        }

        public CounterView(int count, Listener onIncrement) {
            this.count = count;
            this.onIncrement = onIncrement;
        }

        public int getCount() {
            return count;
        }

        public Listener getOnIncrement() {
            return onIncrement;
        }
    }
}


