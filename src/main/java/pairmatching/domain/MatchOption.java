package pairmatching.domain;

public enum MatchOption {
    YES("네"),
    NO("아니오");

    private final String command;

    MatchOption(String command) {
        this.command = command;
    }
}
