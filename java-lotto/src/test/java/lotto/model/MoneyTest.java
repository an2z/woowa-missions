package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("1000원 미만일 경우 예외 발생 확인")
    @Test
    void createMoneyBySmallAmount() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1000원 단위가 아닐 경우 예외 발생 확인")
    @Test
    void createMoneyByWrongUnit() {
        assertThatThrownBy(() -> new Money(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1000원 단위일 경우 객체 생성 확인")
    @Test
    void createMoney() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }
}
