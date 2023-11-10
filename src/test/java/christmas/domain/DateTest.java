package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {
    @DisplayName("날짜가 1일 ~ 31일이 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 32, 33, 99})
    @ParameterizedTest
    void wrongDayEx(int day) {
        Assertions.assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
