package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderMenusTest {
    @DisplayName("한번에 주문하는 메뉴 개수가 20개가 넘을 경우 예외가 발생한다.")
    @Test
    void totalCountEx() {
        //given
        OrderMenu orderMenu1 = new OrderMenu(Menu.TAPAS, 10);
        OrderMenu orderMenu2 = new OrderMenu(Menu.ICE_CREAM, 20);
        List<OrderMenu> menus = List.of(orderMenu1, orderMenu2);

        //when,then
        Assertions.assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하는 경우 예외가 발생한다.")
    @Test
    void onlyDrinkEx() {
        //given
        OrderMenu drinkMenu1 = new OrderMenu(Menu.RED_WINE, 1);
        OrderMenu drinkMenu2 = new OrderMenu(Menu.CHAMPAGNE, 1);
        List<OrderMenu> menus = List.of(drinkMenu1, drinkMenu2);

        //when,then
        Assertions.assertThatThrownBy(() -> new OrderMenus(menus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
