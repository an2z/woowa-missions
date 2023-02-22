package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayersTest {
    Player pobi = new Player("pobi");
    Player honux = new Player("honux");
    Player crong = new Player("crong");
    List<Player> players;

    @BeforeEach
    void setUp() {
        players = Arrays.asList(pobi, honux, crong);
    }

    @Test
    @DisplayName("플레이어가 2명 미만일 경우 예외가 발생한다.")
    void validateSize() {
        List<Player> players = Arrays.asList(pobi);

        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어들을 성공적으로 생성한다.")
    void successMakingPlayers() {
        assertThatNoException().isThrownBy(() -> new Players(players));
    }

    @Test
    @DisplayName("플레이어들이 몇명인지 구한다.")
    void getSize() {
        int size = new Players(players).getSize();
        assertThat(size).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어 이름 중 가장 긴 이름의 길이를 구한다.")
    void getMaxNameLength() {
        int maxNameLength = new Players(players).getMaxNameLength();
        assertThat(maxNameLength).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource({"p, 1", "po, 2", "pob, 3", "pobi, 4", "pobii, 5"})
    @DisplayName("가장 첫번째 플레이어 이름의 길이를 구한다.")
    void getFirstNameLength(String firstName, int expected) {
        Players players = new Players(Arrays.asList(new Player(firstName), honux));
        int firstNameLength = players.getFirstNameLength();
        assertThat(firstNameLength).isEqualTo(expected);
    }

    @Test
    @DisplayName("가장 첫번째 플레이어 이름을 구한다. ")
    void getFirstName() {
        String firstName = new Players(players).getFirstName();
        assertThat(firstName).isEqualTo("pobi");
    }

    @Test
    @DisplayName("모든 플레이어의 이름을 구한다.")
    void getAllNames() {
        List<String> allNames = new Players(players).getAllNames();
        assertThat(allNames).containsExactly("pobi", "honux", "crong");
    }

    @Test
    @DisplayName("VO 동등 비교를 확인한다.")
    void checkVO() {
        Players players1 = new Players(players);
        Players players2 = new Players(players);

        assertThat(players1).isEqualTo(players2);
        assertThat(players1).hasSameHashCodeAs(players2);
    }
}
