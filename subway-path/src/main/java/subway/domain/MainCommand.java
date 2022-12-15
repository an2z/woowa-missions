package subway.domain;

import java.util.Arrays;

public enum MainCommand {
    LOOKUP("1"),
    QUIT("Q");

    private static final String INVALID_COMMAND_ERROR = "1 또는 Q 중 하나의 값을 입력해주세요.";

    private final String command;

    MainCommand(String command) {
        this.command = command;
    }

    public static MainCommand find(String command) {
        return Arrays.stream(values())
                .filter(mainCommand -> mainCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_ERROR));
    }

    public boolean isLookup() {
        return this.equals(LOOKUP);
    }
}
