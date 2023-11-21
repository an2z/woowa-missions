package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ComputerTest {

    @DisplayName("VO 동등 비교 확인")
    @CsvSource({
            "1, 2, 3",
            "4, 5, 6",
            "7, 8, 9",
    })
    @ParameterizedTest
    void checkValueObject(int number1, int number2, int number3) {
        List<Integer> numbers = Arrays.asList(number1, number2, number3);
        Computer computer1 = new Computer(numbers);
        Computer computer2 = new Computer(numbers);
        assertThat(computer1).isEqualTo(computer2);
        assertThat(computer1).hasSameHashCodeAs(computer2);
    }
}
