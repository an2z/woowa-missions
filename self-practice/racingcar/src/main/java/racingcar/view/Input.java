package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final int MIN_COUNT = 1;
    private static final String REGEX = ",";
    private static final String COUNT_ERROR_MESSAGE = "최소 %d번 이상 경주를 진행해야 합니다.";

    public static String[] readCarNames() {
        return read().split(REGEX);
    }

    public static int readRacingCount() {
        return checkCount(Integer.valueOf(read()));
    }

    private static int checkCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(String.format(COUNT_ERROR_MESSAGE, MIN_COUNT));
        }
        return count;
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
