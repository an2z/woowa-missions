package menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoachTest {

    @DisplayName("코치의 이름이 2~4글자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"일", "일이삼사오"})
    void makeCoachEx(String name) {
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("코치의 싫어하는 메뉴가 0~2개가 아닐 경우 예외가 발생한다.")
    @Test
    void addHateMenuEx() {
        // given
        Coach coach = new Coach("토미");
        String[] hateMenu = new String[]{"우동", "스시", "비빔밥"};

        // when, then
        assertThatThrownBy(() -> coach.addHateMenu(hateMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
