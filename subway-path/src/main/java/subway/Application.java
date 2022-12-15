package subway;

import java.util.Scanner;
import subway.domain.InitDB;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InitDB.init();
    }
}
