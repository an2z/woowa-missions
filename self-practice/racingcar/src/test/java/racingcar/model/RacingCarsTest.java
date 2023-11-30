package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {
    @DisplayName("경주할 자동차가 2대 미만일 경우 예외가 발생한다.")
    @Test
    void makeRacingCarsWithSmallSize() {
        assertThatThrownBy(() -> new RacingCars(List.of(new Car("pobi"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("경주할 자동차에 같은 자동차가 있으면 예외가 발생한다.")
    @Test
    void makeRacingCarsWithNotUnique() {
        Car pobiCar = new Car("pobi");
        assertThatThrownBy(() -> new RacingCars(List.of(pobiCar, pobiCar)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
