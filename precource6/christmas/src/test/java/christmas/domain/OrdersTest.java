package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrdersTest {
    @DisplayName("한번에 주문하는 메뉴 개수가 20개가 넘을 경우 예외가 발생한다.")
    @Test
    void totalCountEx() {
        //given
        Order order1 = new Order(Menu.TAPAS, 10);
        Order order2 = new Order(Menu.ICE_CREAM, 20);
        List<Order> orders = List.of(order1, order2);

        //when,then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 주문하는 경우 예외가 발생한다.")
    @Test
    void onlyDrinkEx() {
        //given
        Order drinkOrder1 = new Order(Menu.RED_WINE, 1);
        Order drinkOrder2 = new Order(Menu.CHAMPAGNE, 1);
        List<Order> orders = List.of(drinkOrder1, drinkOrder2);

        //when,then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 메뉴를 주문하는 경우 예외가 발생한다.")
    @Test
    void duplicatedMenuEx() {
        //given
        Order order1 = new Order(Menu.TAPAS, 1);
        Order order2 = new Order(Menu.TAPAS, 2);
        List<Order> orders = List.of(order1, order2);

        //when,then
        Assertions.assertThatThrownBy(() -> new Orders(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
