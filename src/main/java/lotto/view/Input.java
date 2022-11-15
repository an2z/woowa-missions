package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.ConstantUtil.ERROR;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;

public final class Input {
    private static final String DIGIT_ERROR_MESSAGE = ERROR + "숫자만 입력 가능합니다.";
    private static final String DIGIT_COMMA_ERROR_MESSAGE = ERROR + "숫자와 콤마(,)만 입력 가능합니다.";
    private static final String RANGE_ERROR_MESSAGE = ERROR + "로또 번호에 1 ~ 45 범위를 벗어난 숫자가 있습니다.";

    public static int inputPurchaseAmount() {
        String input = validateDigit(readLine());
        return convertToInt(input);
    }

    public static String inputWinningNumbers() {
        return validateDigitAndComma(readLine());
    }

    public static int inputBonusNumber() {
        String input = validateDigit(readLine());
        return validateNumberRange(convertToInt(input));
    }

    private static String validateDigit(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }

        return input;
    }

    private static String validateDigitAndComma(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_COMMA_ERROR_MESSAGE);
        }

        return input;
    }

    private static int validateNumberRange(int number) {
        if (isNotValidRange(number)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }

        return number;
    }

    private static boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }

    private static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private Input() {
    }
}
