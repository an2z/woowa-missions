package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String DELIMITER = ",";
    private static final String DIGIT_DELIMITER_REGEX = "[0-9,]";
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자만 가능합니다.";
    private static final String DELIMITER_ERROR = "[ERROR] 숫자와 %s만 가능합니다.";

    public int readAmount() {
        return convertToInt(input());
    }

    public List<Integer> readWinningNumbers() {
        return convertToList(input());
    }

    private List<Integer> convertToList(String numbers) {
        checkDigitAndDelimiter(numbers);
        return Arrays.stream(numbers.split(DELIMITER))
                .map(this::convertToInt)
                .collect(Collectors.toList());
    }

    private void checkDigitAndDelimiter(String numbers) {
        String result = numbers.replaceAll(DIGIT_DELIMITER_REGEX, "");
        if (result.length() != 0) {
            throw new IllegalArgumentException(String.format(DELIMITER_ERROR, DELIMITER));
        }
    }

    private int convertToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
