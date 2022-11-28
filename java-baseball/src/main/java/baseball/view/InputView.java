package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

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
            throw new IllegalArgumentException("[ERROR] 숫자 형식만 가능합니다.");
        }
    }

    private String input() {
        return readLine();
    }
}
