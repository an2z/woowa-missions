package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.Input;

import java.util.List;

public class RacingController {
    private final Input input = new Input();

    public void run() {
        makeRacingCars();
    }

    public RacingCars makeRacingCars() {
        return new RacingCars(makeCars());
    }

    public List<Car> makeCars() {
        return input.readCarNames().stream()
                .map(Car::new)
                .toList();
    }
}
