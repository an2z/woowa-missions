package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Car pobiCar;
    private Car woniCar;
    private Car junCar;

    @BeforeEach
    void setUp() {
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
        junCar = new Car("jun");
    }

    @Test
    @DisplayName("자동차가 2대 미만일 경우 예외가 발생한다.")
    void checkCarSizeError() {
        List<Car> cars = Arrays.asList(pobiCar);

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주할 자동차가 몇대인지 구한다.")
    void getSize() {
        Cars cars = new Cars(Arrays.asList(pobiCar, woniCar, junCar));

        assertThat(cars.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("경주 최종 우승 자동차를 구한다.")
    void findWinner() {
        Cars cars = new Cars(Arrays.asList(pobiCar, woniCar, junCar));
        pobiCar.move(4);

        List<Car> winner = cars.findWinner();

        assertThat(winner).hasSize(1);
        assertThat(winner).contains(pobiCar);
    }

    @Test
    @DisplayName("VO 동등 비교를 확인한다.")
    void checkVO() {
        Cars cars1 = new Cars(Arrays.asList(pobiCar, woniCar, junCar));
        Cars cars2 = new Cars(Arrays.asList(pobiCar, woniCar, junCar));

        assertThat(cars1).isEqualTo(cars2);
        assertThat(cars1).hasSameHashCodeAs(cars2);
    }
}
