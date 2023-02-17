package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String REGEX = ",";

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readNames() {
        return Arrays.asList(read().split(REGEX));
    }

    private static String read() {
        return sc.nextLine();
    }

    private Input() {
    }
}
