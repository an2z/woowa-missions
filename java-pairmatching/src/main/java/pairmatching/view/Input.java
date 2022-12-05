package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String readFunction() {
        return input();
    }

    private String input() {
        return Console.readLine();
    }
}
