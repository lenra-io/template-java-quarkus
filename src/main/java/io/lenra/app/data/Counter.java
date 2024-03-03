package io.lenra.app.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Counter extends io.lenra.app.data.Data {
    private String user;
    private int count;

    public Counter(String user, int count) {
        this.user = user;
        this.count = count;
    }
}
