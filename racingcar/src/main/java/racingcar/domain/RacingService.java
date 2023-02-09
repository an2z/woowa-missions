package racingcar.domain;

import static racingcar.domain.RandomNumberMaker.makeRandomNumbers;

import java.util.ArrayList;
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
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = new Cars(cars);
    }
}
