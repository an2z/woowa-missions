package subway.veiw;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }
}
