package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("랜덤 값이 4 이상일 경우 자동차가 전진한다.")
    @Test
    void race() {
        // given
        Car pobi = new Car("pobi");
        Car wori = new Car("wori");
        Car jun = new Car("jun");
        RacingCars racingCars = new RacingCars(List.of(pobi, wori, jun));

        // when
        List<Integer> randomNumbers = List.of(1, 2, 4);
        racingCars.race(randomNumbers);

        // then
        assertThat(pobi.getMovement()).isZero();
        assertThat(wori.getMovement()).isZero();
        assertThat(jun.getMovement()).isEqualTo(1);
    }
}
