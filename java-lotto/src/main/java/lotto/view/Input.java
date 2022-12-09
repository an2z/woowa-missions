package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String NUMBER_FORMAT_ERROR = "[ERROR] 숫자만 가능합니다.";

    public int readAmount() {
        return convert(input());
    }

    private int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
