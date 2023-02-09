package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private Cars cars;

    public void makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = new Cars(cars);
    }
}
