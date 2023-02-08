package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] readCarNames() {
        return read().split(",");
    }

    public static int readRacingCount() {
        return checkCount(Integer.valueOf(read()));
    }

    private static int checkCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("최소 1번 이상 경주를 진행해야 합니다.");
        }
        return count;
    }

    private static String read() {
        return Console.readLine();
    }

    private Input() {
    }
}
