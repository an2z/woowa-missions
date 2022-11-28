package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    private final BaseBallGame game = new BaseBallGame();

    @Test
    void makePlayer() {
        Player createdPlayer = game.makePlayer("123");
        assertThat(createdPlayer).isEqualTo(new Player(Arrays.asList(1, 2, 3)));
    }
}
