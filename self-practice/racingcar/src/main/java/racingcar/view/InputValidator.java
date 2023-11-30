package racingcar.view;

public class InputValidator {
    private static final String CAR_NAMES_REGEX = "[a-zA-Z가-힣,]";
    private static final String DIGIT_REGEX = "[0-9]";

    public static String validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        return input;
    }

    public static String validateCarNamesFormat(String input) {
        if (isWrongValue(input, CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("자동차 이름 입력이 잘못되었습니다.");
        }
        return input;
    }

    public static String validateNumber(String input) {
        if (isWrongValue(input, DIGIT_REGEX) || input.equals("0")) {
            throw new IllegalArgumentException("이동 횟수 입력이 잘못되었습니다.");
        }
        return input;
    }

    private static boolean isWrongValue(String input, String regex) {
        return input.replaceAll(regex, "").length() > 0;
    }

    private InputValidator() {
    }
}
