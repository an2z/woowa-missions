package racingcar.controller;

import static racingcar.view.Input.readCarNames;
import static racingcar.view.Input.readRacingCount;
import static racingcar.view.Output.printCarNames;
import static racingcar.view.Output.printRacingCount;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingController {

    public void run() {
        printCarNames();
        Cars cars = makeCars(readCarNames());

        printRacingCount();
        int count = readRacingCount(); // todo: NumberFormat 오류 처리
    }

    private static Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }
}
