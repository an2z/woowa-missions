package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusTest {

    @DisplayName("보너스 번호가 1부터 45 범위 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createBonusWithWrongNumber() {
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("₩")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "7, false",
            "8, false",
            "45, false"
    })
    @ParameterizedTest
    void checkSameNumber(int number, boolean expected) {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(number);

        boolean actual = bonus.isExist(lotto);

        assertThat(actual).isEqualTo(expected);
    }
}
