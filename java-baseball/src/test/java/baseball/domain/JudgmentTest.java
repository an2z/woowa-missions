package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgmentTest {

    private final Judgment judgment = new Judgment();
    private final Computer computer = new Computer(Arrays.asList(1, 2, 3));

    @DisplayName("볼의 개수를 확인한다.")
    @CsvSource({
            "5, 6, 7, 0",
            "6, 7, 1, 1",
            "5, 1, 2, 2",
            "2, 3, 1, 3"
    })
    @ParameterizedTest
    void makeBall(int number1, int number2, int number3, int expected) {
        Player player = new Player(Arrays.asList(number1, number2, number3));
        judgment.judge(computer, player);
        int actual = judgment.getBall();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("스트라이크 개수를 확인한다.")
    @CsvSource({
            "3, 1, 2, 0",
            "1, 3, 2, 1",
            "1, 2, 4, 2",
            "1, 2, 3, 3",
    })
    @ParameterizedTest
    void makeStrike(int number1, int number2, int number3, int expected) {
        Player player = new Player(Arrays.asList(number1, number2, number3));
        judgment.judge(computer, player);
        int actual = judgment.getStrike();
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("3스트라이크인지 확인한다.")
    @CsvSource({
            "1, 2, 3, true",
            "1, 3, 2, false",
            "3, 2, 1, false"
    })
    @ParameterizedTest
    void makeAllStrike(int number1, int number2, int number3, boolean expected) {
        Player player = new Player(Arrays.asList(number1, number2, number3));
        judgment.judge(computer, player);
        boolean actual = judgment.isAllStrike();
        assertThat(actual).isEqualTo(expected);
    }
}
