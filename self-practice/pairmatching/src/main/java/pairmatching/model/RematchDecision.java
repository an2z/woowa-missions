package pairmatching.model;

import java.util.Arrays;

public enum RematchDecision {
    YES("네"),
    NO("아니오");

    private final String command;

    RematchDecision(String command) {
        this.command = command;
    }

    public static RematchDecision find(String command) {
        return Arrays.stream(values())
                .filter(decision -> decision.command.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
