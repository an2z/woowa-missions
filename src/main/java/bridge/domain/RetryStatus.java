package bridge.domain;

import java.util.Arrays;

public enum RetryStatus {

    RETRY("R", "재시도"),
    QUIT("Q", "종료");


    private static final String INVALID_COMMAND_MESSAGE = "R과 Q 중 하나의 값을 입력해주세요.";

    private final String command;
    private final String description;

    RetryStatus(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static RetryStatus find(String command) {
        return Arrays.stream(values())
                .filter(retryStatus -> retryStatus.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }
}
