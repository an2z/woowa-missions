package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource({"' '", "매우긴자동차이름"})
    @DisplayName("자동차 이름이 1 ~ 5글자가 아닐 경우 예외가 발생한다.")
    void checkNameLengthError(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 0", "2, 0", "3, 0", "4, 1", "5, 1"})
    @DisplayName("4 이상의 숫자일 경우에만 이동하다.")
    void move(int number, int position) {
        Car car = new Car("pobi");
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("VO 동등 비교를 확인한다.")
    void checkVO() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");

        assertThat(car1).isEqualTo(car2);
        assertThat(car1).hasSameHashCodeAs(car2);
    }
}
