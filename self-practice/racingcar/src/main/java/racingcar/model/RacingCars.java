package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

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

    public void race(List<Integer> randomNumbers) {
        IntStream.range(0, cars.size())
                .filter(i -> isCanMove(randomNumbers.get(i)))
                .forEach(i -> cars.get(i).move());
    }

    private boolean isCanMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<Car> findWinner() {
        int maxMovement = findMaxMovement();
        return cars.stream()
                .filter(car -> car.isMaxMovement(maxMovement))
                .toList();
    }

    private int findMaxMovement() {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElseThrow(() -> new IllegalStateException("최대 값을 찾을 수 없습니다."));
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
