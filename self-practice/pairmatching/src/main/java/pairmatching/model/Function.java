package pairmatching.model;

import java.util.Arrays;

public enum Function {
    MATCHING("1", "페어 매칭"),
    LOOKUP("2", "페어 조회"),
    INITIALIZATION("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String command;
    private final String description;

    Function(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static Function of(String command) {
        return Arrays.stream(values())
                .filter(function -> function.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("기능을 찾을 수 없습니다."));
    }

    @Override
    public String toString() {
        return String.format("%s. %s", command, description);
    }
}
