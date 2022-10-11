package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RefereeTest {
    @Test
    void 스트라이크3() {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        Assertions.assertThat(result).isEqualTo("0 볼 3 스트라이크");
    }

    @Test
    void 아웃() {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        Assertions.assertThat(result).isEqualTo("아웃");
    }

    @Test
    void 볼3() {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2));
        Assertions.assertThat(result).isEqualTo("3 볼 0 스트라이크");
    }

    @Test
    void 볼2_스트라이크1() {
        Referee referee = new Referee();
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 3));
        Assertions.assertThat(result).isEqualTo("2 볼 1 스트라이크");
    }
}