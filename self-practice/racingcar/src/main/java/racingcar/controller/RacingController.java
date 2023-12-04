package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RandomNumberMaker;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.function.Supplier;

public class RacingController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        RacingCars racingCars = retry(this::makeRacingCars);
        int count = retry(input::readNumber);
        startRacing(racingCars, count);
        output.showWinner(racingCars.findWinner());
    }

    public void startRacing(RacingCars racingCars, int count) {
        output.showRacingResult();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = RandomNumberMaker.makeRandomNumbers(racingCars.getSize());
            racingCars.race(randomNumbers);
            output.showRacingStatus(racingCars);
        }
    }

    public RacingCars makeRacingCars() {
        return new RacingCars(makeCars());
    }

    public List<Car> makeCars() {
        return input.readCarNames().stream()
                .map(Car::new)
                .toList();
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.showError(e.getMessage());
            }
        }
    }
}
