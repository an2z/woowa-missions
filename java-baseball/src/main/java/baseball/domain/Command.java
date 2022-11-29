package baseball.domain;

public class Command {

    private static final String STOP = "2";
    private static final String RESTART = "1";
    private static final String COMMAND_ERROR = "[ERROR] %s 또는 %s만 가능합니다.";

    private final String status;

    public Command(String status) {
        validate(status);
        this.status = status;
    }

    public boolean restarts() {
        return status.equals(RESTART);
    }

    private void validate(String status) {
        if (isWrongStatus(status)) {
            throw new IllegalArgumentException(String.format(COMMAND_ERROR, RESTART, STOP));
        }
    }

    private boolean isWrongStatus(String status) {
        return !(status.equals(RESTART) || status.equals(STOP));
    }
}
