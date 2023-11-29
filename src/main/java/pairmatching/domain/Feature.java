package pairmatching.domain;

public enum Feature {
    PAIR_MATCHING("1", "페어 매칭"),
    PAIR_LOOKUP("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    EXIT("Q", "종료");

    private final String command;
    private final String description;

    Feature(String command, String description) {
        this.command = command;
        this.description = description;
    }
}
