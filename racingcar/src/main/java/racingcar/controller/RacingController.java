package racingcar.controller;

import static racingcar.view.Input.readCarNames;
import static racingcar.view.Output.printCarNames;

public class RacingController {
    public void run() {
        printCarNames();
        readCarNames();
    }
}
