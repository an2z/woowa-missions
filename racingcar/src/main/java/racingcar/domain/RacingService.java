package racingcar.domain;

import static java.util.stream.Collectors.toList;
import static racingcar.domain.RandomNumberMaker.makeRandomNumbers;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    private Cars cars;

    public List<Car> findWinner() {
        return cars.findWinner();
    }

    public Cars moveCars() {
        return cars.move(makeRandomNumbers(cars.getSize()));
    }

    public void makeCars(String[] carNames) {
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(toList());

        this.cars = new Cars(cars);
    }
}
