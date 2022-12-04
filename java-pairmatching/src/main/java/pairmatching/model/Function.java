package pairmatching.model;

import java.util.Arrays;

public enum Function {
    MATCHING("1", "페어 매칭"),
    LOOKUP("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String SIGN_ERROR = "[ERROR] 1, 2, 3, Q 중에서 선택해주세요.";

    private final String sign;
    private final String explain;

    Function(String sign, String explain) {
        this.sign = sign;
        this.explain = explain;
    }

    public static Function getBySign(String sign) {
        return Arrays.stream(Function.values())
                .filter(value -> sign.equals(value.sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(SIGN_ERROR));
    }

    @Override
    public String toString() {
        return sign + ". " + explain;
    }
}
