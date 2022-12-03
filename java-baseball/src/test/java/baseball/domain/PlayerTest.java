package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {

    @DisplayName("3자리 수가 아닐 경우 예외 발생 확인")
    @Test
    void makeNumbersWrongSize() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertThrows(IllegalArgumentException.class,
                () -> new Player(numbers));
    }

    @DisplayName("각 자리 숫자가 1부터 9까지의 숫자가 아닐 경우 예외 발생 확인")
    @CsvSource({
            "0, 1, 2",
            "1, 0 ,2",
            "1, 2, 0"
    })
    @ParameterizedTest
    void makeNumbersOutOfRange(int number1, int number2, int number3) {
        List<Integer> numbers = Arrays.asList(number1, number2, number3);
        assertThrows(IllegalArgumentException.class,
                () -> new Player(numbers));
    }

    @DisplayName("각 자리 숫자가 서로 다른 숫자가 아닐 경우 예외 발생 확인")
    @CsvSource({
            "1, 1, 2",
            "1, 2, 2",
            "1, 2, 1",
            "1, 1, 1"
    })
    @ParameterizedTest
    void makeDuplicatedNumbers(int number1, int number2, int number3) {
        List<Integer> numbers = Arrays.asList(number1, number2, number3);
        assertThrows(IllegalArgumentException.class,
                () -> new Player(numbers));
    }

    @DisplayName("VO 동등 비교 확인")
    @CsvSource({
            "1, 2, 3",
            "4, 5, 6",
            "7, 8, 9",
    })
    @ParameterizedTest
    void checkValueObject(int number1, int number2, int number3) {
        Player player1 = new Player(Arrays.asList(number1, number2, number3));
        Player player2 = new Player(Arrays.asList(number1, number2, number3));
        assertThat(player1).isEqualTo(player2);
        assertThat(player1).hasSameHashCodeAs(player2);
    }
}
