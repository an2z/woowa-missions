package racingcar.controller;

import static racingcar.view.Input.readCarNames;
import static racingcar.view.Output.printCarNames;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingController {

    public void run() {
        printCarNames();
        Cars cars = makeCars(readCarNames());
    }

    private static Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }
}
