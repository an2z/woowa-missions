package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String REGEX = ",";
    private static final String NUMBER_FORMAT_ERROR = "숫자를 입력해주세요.";

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readNames() {
        return Arrays.asList(read().split(REGEX));
    }

    public static int readLadderHeight() {
        return toInteger(read());
    }

    private static Integer toInteger(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private static String read() {
        return sc.nextLine();
    }

    private Input() {
    }
}
