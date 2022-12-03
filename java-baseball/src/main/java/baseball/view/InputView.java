package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자 형식만 가능합니다.";

    public String readPlayerNumbers() {
        String input = input();
        validateNumberFormat(input);
        return input;
    }

    public String readGameCommand() {
        return input();
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return readLine();
    }
}
