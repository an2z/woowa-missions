package pairmatching.model;

import java.util.Arrays;

public enum Function {
    MATCHING("1"),
    FIND("2"),
    INIT("3"),
    QUIT("Q");

    private static final String SIGN_ERROR = "[ERROR] 1, 2, 3, Q 중에서 선택해주세요.";

    private String sign;

    Function(String sign) {
        this.sign = sign;
    }

    public static Function getBySign(String sign) {
        return Arrays.stream(Function.values())
                .filter(value -> sign.equals(value.sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(SIGN_ERROR));
    }
}
