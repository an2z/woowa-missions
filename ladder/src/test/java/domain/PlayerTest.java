package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerTest {
    @ParameterizedTest
    @CsvSource({"''", "매우긴플레이어이름"})
    @DisplayName("이름이 1~5글자가 아니면 예외가 발생한다.")
    void validateNameLength(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("VO 동등 비교를 확인한다.")
    void checkVO() {
        Player player1 = new Player("pobi");
        Player player2 = new Player("pobi");

        assertThat(player1).isEqualTo(player2);
        assertThat(player2).hasSameHashCodeAs(player2);
    }
}
