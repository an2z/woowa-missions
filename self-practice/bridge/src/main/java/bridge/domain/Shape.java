package bridge.domain;

import java.util.Arrays;

public enum Shape {

    UP("U"),
    DOWN("D");

    private static final String NOT_FOUND_ERROR = "모양을 찾을 수 없습니다.";

    private final String symbol;

    Shape(String symbol) {
        this.symbol = symbol;
    }

    public static Shape find(String symbol) {
        return Arrays.stream(values())
                .filter(shape -> shape.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }

    public String getSymbol() {
        return symbol;
    }
}
