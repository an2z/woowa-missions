package pairmatching.model;

import java.util.Arrays;

public enum Function {
    MATCHING("1", "페어 매칭"),
    LOOKUP("2", "페어 조회"),
    INIT("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String SIGN_ERROR = "[ERROR] 1, 2, 3, Q 중에서 선택해주세요.";

    private final String command;
    private final String explain;

    Function(String command, String explain) {
        this.command = command;
        this.explain = explain;
    }

    public static Function find(String command) {
        return Arrays.stream(Function.values())
                .filter(value -> command.equals(value.command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(SIGN_ERROR));
    }

    @Override
    public String toString() {
        return command + ". " + explain;
    }
}
