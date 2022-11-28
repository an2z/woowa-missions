package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumbersGeneratorTest {

    private final NumbersGenerator generator = new NumbersGenerator();

    @DisplayName("컴퓨터 수로 3자리 숫자가 생성된다.")
    @Test
    void makeComputer() {
        List<Integer> numbers = generator.makeComputer();
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("플레이어 수가 생성된다.")
    @CsvSource({
            "123, 1, 2, 3",
            "456, 4, 5, 6",
            "789, 7, 8, 9"
    })
    @ParameterizedTest
    void makePlayer(String input, int number1, int number2, int number3) {
        List<Integer> numbers = generator.makePlayer(input);
        List<Integer> expected = Arrays.asList(number1, number2, number3);
        assertThat(numbers).isEqualTo(expected);
    }
}
