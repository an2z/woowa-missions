package bridge.view;

public class InputValidator {

    private InputValidator() {
    }

    public static String validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        return input;
    }
}
