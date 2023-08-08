package menu;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputCoachName() {
        return read();
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
