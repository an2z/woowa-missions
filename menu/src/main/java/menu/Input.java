package menu;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static final String SEPARATOR = ",";

    public static String[] inputCoachName() {
        return read().split(SEPARATOR);
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
