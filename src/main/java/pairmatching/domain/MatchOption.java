package pairmatching.domain;

import java.util.Arrays;

public enum MatchOption {
    YES("네"),
    NO("아니오");

    private final String command;

    MatchOption(String command) {
        this.command = command;
    }

    public static MatchOption find(String command) {
        return Arrays.stream(values())
                .filter(matchOption -> matchOption.command.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); // TODO: 에러 메시지 작성
    }
}
