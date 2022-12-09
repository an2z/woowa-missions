package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("1000원이 몇개인지 계산한다.")
    @CsvSource({
            "1000, 1",
            "2000, 2",
            "10000, 10",
            "15000, 15"
    })
    @ParameterizedTest
    void countMoney(int amount, int expected) {
        Money money = new Money(amount);
        int actual = money.count();
        assertThat(actual).isEqualTo(expected);
    }
}
