package bridge.view;

public class InputValidator {

    private static final String DIGIT_REGEX = "[0-9]";
    private static final String MOVING_REGEX = "[U,D]";

    private InputValidator() {
    }

    public static String validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        return input;
    }

    public static String validateDigit(String input) {
        if (isWrongValue(input, DIGIT_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        return input;
    }

    public static String validateMoving(String input) {
        if (isWrongValue(input, MOVING_REGEX)) {
            throw new IllegalArgumentException("U 또는 D을 입력해야 합니다.");
        }
        return input;
    }

    private static boolean isWrongValue(String input, String regex) {
        return input.replaceAll(regex, "").length() > 0;
    }
}
