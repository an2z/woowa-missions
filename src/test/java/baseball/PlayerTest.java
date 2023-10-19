package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어 수가 3자리가 아닌 경우 예외가 발생한다.")
    @Test
    void makePlayerSizeEx() {
        Assertions.assertThatThrownBy(() -> new Player("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
