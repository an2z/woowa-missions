package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.Input;

import java.util.List;

public class RacingController {
    private final Input input = new Input();

    public void run() {
        makeCars();
    }

    public List<Car> makeCars() {
        return input.readCarNames().stream()
                .map(Car::new)
                .toList();
    }
}
