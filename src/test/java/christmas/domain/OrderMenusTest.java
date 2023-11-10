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
}
