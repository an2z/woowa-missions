package subway.domain;

import java.util.Arrays;

public enum StandardCommand {
    DISTANCE("1"),
    TIME("2"),
    BACK("B");

    private static final String INVALID_COMMAND_ERROR = "1, 2, B 중 하나의 값을 입력해주세요.";

    private final String command;

    StandardCommand(String command) {
        this.command = command;
    }

    public static StandardCommand find(String command) {
        return Arrays.stream(values())
                .filter(standardCommand -> standardCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_ERROR));
    }

    public boolean isDistance() {
        return this.equals(DISTANCE);
    }
}
