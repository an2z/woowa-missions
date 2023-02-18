package domain;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("플레이어가 2명 미만일 경우 예외가 발생한다.")
    void validateSize() {
        List<Player> players = Arrays.asList(new Player("pobi"));

        Assertions.assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
