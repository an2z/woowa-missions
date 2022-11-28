package baseball.domain;

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
}
