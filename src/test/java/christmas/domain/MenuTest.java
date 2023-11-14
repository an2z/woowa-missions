package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {
    @DisplayName("메뉴판에 없는 메뉴일 경우 예외가 발생한다.")
    @Test
    void notFoundMenuEx() {
        assertThatThrownBy(() -> Menu.find("없는메뉴"))
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
        assertThat(menu).isEqualTo(expected);
    }

    @DisplayName("메뉴가 주어진 카테고리인지 확인한다.")
    @CsvSource({
            "ZERO_COLA, DRINK, true",
            "ZERO_COLA, MAIN, false",
            "CHOCO_CAKE, DESSERT, true",
            "CHOCO_CAKE, APPETIZER, false"
    })
    @ParameterizedTest
    void checkCategoryOfMenu(Menu menu, Menu.Category category, boolean expected) {
        boolean result = menu.checkCategory(category);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("양송이수프 개수에 따른 금액을 구한다.")
    @CsvSource({"1, 6000", "2, 12000", "3, 18000"})
    @ParameterizedTest
    void calculatePrice(int count, int expected) {
        int result = Menu.MUSHROOM_SOUP.calculatePrice(count);
        assertThat(result).isEqualTo(expected);
    }
}
