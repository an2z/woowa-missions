package racingcar.controller;

import static racingcar.domain.RandomNumberMaker.makeRandomNumber;
import static racingcar.view.Input.readCarNames;
import static racingcar.view.Input.readRacingCount;
import static racingcar.view.Output.printCarNames;
import static racingcar.view.Output.printError;
import static racingcar.view.Output.printRacingCount;
import static racingcar.view.Output.printRacingResult;
import static racingcar.view.Output.printResult;
import static racingcar.view.Output.printWinner;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingController {

    public void run() {
        printCarNames();
        Cars cars = repeatMakeCars();

        printRacingCount();
        int count = repeatReadRacingCount();

        move(cars, count);
        printWinner(cars.findWinner());
    }

    private void move(Cars cars, int count) {
        printResult();
        for (int c = 0; c < count; c++) {
            Cars movedCars = cars.move(makeRandomNumbers(cars.getSize()));
            printRacingResult(movedCars);
        }
    }

    private static List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(makeRandomNumber());
        }

        return numbers;
    }

    private int repeatReadRacingCount() {
        try {
            return readRacingCount();
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return repeatReadRacingCount();
        }
    }

    private Cars repeatMakeCars() {
        try {
            return makeCars(readCarNames());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return repeatMakeCars();
        }
    }

    private static Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }
}
