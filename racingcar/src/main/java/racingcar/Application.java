package racingcar;

import static racingcar.view.Input.readCarNames;
import static racingcar.view.Output.printCarNames;

public class Application {
    public static void main(String[] args) {
        printCarNames();
        readCarNames();
    }
}
