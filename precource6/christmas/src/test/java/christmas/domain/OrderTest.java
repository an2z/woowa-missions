package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("주문 개수가 1개보다 적으면 예외가 발생한다.")
    @Test
    void validateCount() {
        assertThatThrownBy(() -> new Order(Menu.BBQ_RIBS, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바르지 않은 주문 정보일 경우 예외가 발생한다.")
    @MethodSource("provideInvalidOrderInfo")
    @ParameterizedTest
    void validateOrderInfo(String[] orderInfo) {
        assertThatThrownBy(() -> Order.from(orderInfo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideInvalidOrderInfo() {
        return Stream.of(
                Arguments.of((Object) new String[]{"해산물파스타1"}),
                Arguments.of((Object) new String[]{"초코케이크_1"}),
                Arguments.of((Object) new String[]{"레드와인", "ㄱ"}),
                Arguments.of((Object) new String[]{"레드와인", "!"})
        );
    }
}
