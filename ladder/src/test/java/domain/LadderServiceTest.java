package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderServiceTest {
    LadderService ladderService = new LadderService();

    @Test
    @DisplayName("이름에 맞는 플레이어를 만든다.")
    void makePlayers() {
        Player pobi = new Player("pobi");
        Player honux = new Player("honux");

        Players players = ladderService.makePlayers(Arrays.asList("pobi", "honux"));

        assertThat(players.getPlayers()).containsExactly(pobi, honux);
    }

    @Test
    @DisplayName("높이에 맞는 사다리를 만든다.")
    void makeLadder() {
        ladderService.makePlayers(Arrays.asList("pobi", "honux"));

        Ladder ladder = ladderService.makeLadder(4);

        assertThat(ladder.getLines()).hasSize(4);
    }
}
