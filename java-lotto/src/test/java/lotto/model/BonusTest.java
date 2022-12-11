package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호가 1부터 45 범위 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createBonusWithWrongNumber() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
