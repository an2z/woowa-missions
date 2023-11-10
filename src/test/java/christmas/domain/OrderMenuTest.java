package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderMenuTest {
    @DisplayName("주문 개수가 1개보다 적으면 예외가 발생한다.")
    @Test
    void validateCount() {
        assertThatThrownBy(() -> new OrderMenu(Menu.BBQ_RIBS, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
