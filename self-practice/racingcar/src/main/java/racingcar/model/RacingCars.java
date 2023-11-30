package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateSize(cars);
        validateUnique(cars);
        this.cars = cars;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이여야 합니다.");
        }
    }

    private void validateUnique(List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException("같은 자동차가 있을 수 없습니다.");
        }
    }

    public void race() {
        cars.forEach(car -> car.move(RandomNumberMaker.makeRandomNumber()));
    }

    public List<Car> getCars() {
        return cars;
    }
}
