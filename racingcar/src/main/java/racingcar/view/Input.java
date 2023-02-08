package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String REGEX = ",";
    private static final String COUNT_ERROR_MESSAGE = "최소 1번 이상 경주를 진행해야 합니다.";

    public static String[] readCarNames() {
        return read().split(REGEX);
    }

    public static int readRacingCount() {
        return checkCount(Integer.valueOf(read()));
    }

    private static int checkCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
        return count;
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
