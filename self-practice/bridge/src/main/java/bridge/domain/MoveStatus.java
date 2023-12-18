package bridge.domain;

public enum MoveStatus {

    SUCCESS("성공"),
    FAIL("실패");

    private final String description;

    MoveStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
