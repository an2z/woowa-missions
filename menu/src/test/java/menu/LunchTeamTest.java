package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LunchTeamTest {

    @DisplayName("코치가 2~5명이 아닐 경우 예외가 발생한다.")
    @Test
    void makeLunchTeamEx() {
        List<Coach> coaches = List.of(new Coach("토미"));

        Assertions.assertThatThrownBy(() -> new LunchTeam(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
