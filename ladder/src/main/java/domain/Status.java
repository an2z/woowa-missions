package domain;

import java.util.Arrays;

public enum Status {
    CONNECTED(true, "-"),
    UNCONNECTED(false, " ");

    private static final String NOT_FOUND_ERROR = "존재하지 않습니다.";

    private final Boolean sign;
    private final String shape;

    Status(Boolean sign, String shape) {
        this.sign = sign;
        this.shape = shape;
    }

    public static Status find(Boolean sign) {
        return Arrays.stream(values())
                .filter(status -> status.sign.equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }

    public boolean isConnected() {
        return this.equals(CONNECTED);
    }

    public String getShape() {
        return shape;
    }
}
