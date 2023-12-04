package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @DisplayName("자동차 이름이 1~5글자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"", "spring", "javajigi"})
    @ParameterizedTest
    void makeCarWithLongName(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차를 전진한다.")
    @Test
    void move() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getMovement()).isEqualTo(1);
    }
}
