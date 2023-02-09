package racingcar.controller;

import static racingcar.view.Input.readCarNames;
import static racingcar.view.Input.readRacingCount;
import static racingcar.view.Output.printCarNames;
import static racingcar.view.Output.printError;
import static racingcar.view.Output.printRacingCount;
import static racingcar.view.Output.printRacingResult;
import static racingcar.view.Output.printResult;
import static racingcar.view.Output.printWinner;

import racingcar.domain.RacingService;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void run() {
        printCarNames();
        repeatMakeCars();

        printRacingCount();

        racing(repeatReadRacingCount());
        printWinner(cars.findWinner());
    }

    private void racing(int count) {
        printResult();
        for (int c = 0; c < count; c++) {
            printRacingResult(racingService.moveCars());
        }
    }

    private int repeatReadRacingCount() {
        try {
            return readRacingCount();
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return repeatReadRacingCount();
        }
    }

    private void repeatMakeCars() {
        try {
            racingService.makeCars(readCarNames());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            repeatMakeCars();
        }
    }
}
