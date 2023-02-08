package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] readCarNames() {
        return read().split(",");
    }

    public static int readRacingCount() {
        return Integer.valueOf(read());
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
