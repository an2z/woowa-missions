package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String readPlayerNumbers() {
        return input();
    }

    public String readGameCommand() {
        return input();
    }

    private String input() {
        return readLine();
    }
}
