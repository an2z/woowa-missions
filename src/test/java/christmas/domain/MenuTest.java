package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {
    @DisplayName("메뉴판에 없는 메뉴일 경우 예외가 발생한다.")
    @Test
    void notFoundMenuEx() {
        Assertions.assertThatThrownBy(() -> Menu.find("없는메뉴"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에서 메뉴를 찾는다.")
    @CsvSource({
            "양송이수프, MUSHROOM_SOUP",
            "티본스테이크, T_BONE_STEAK",
            "초코케이크, CHOCO_CAKE",
            "제로콜라, ZERO_COLA"
    })
    @ParameterizedTest
    void findMenu(String name, Menu expected) {
        Menu menu = Menu.find(name);
        Assertions.assertThat(menu).isEqualTo(expected);
    }
}
