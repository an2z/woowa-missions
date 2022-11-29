package baseball.domain;

public class Command {

    private final String status;

    public Command(String status) {
        validate(status);
        this.status = status;
    }

    public boolean restarts() {
        return status.equals("1");
    }

    private void validate(String status) {
        if (isWrongStatus(status)) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2만 가능합니다.");
        }
    }

    private boolean isWrongStatus(String status) {
        return !(status.equals("1") || status.equals("2"));
    }
}
