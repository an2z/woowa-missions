package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
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

        move(cars, count);
        cars.findWinner();
    }

    private void move(Cars cars, int count) {
        for (int c = 0; c < count; c++) {
            cars.move(makeRandomNumbers(cars.getSize()));
        }
    }

    private static List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(pickNumberInRange(0, 9));
        }

        return numbers;
    }

    private static Cars makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return new Cars(cars);
    }
}
