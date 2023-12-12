package io.lenra.app.data;

public class Counter extends Data {
    private int count;
    private String user;

    public Counter() {
    }

    public Counter(int count, String user) {
        super();
        this.count = count;
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public String getUser() {
        return user;
    }
}
