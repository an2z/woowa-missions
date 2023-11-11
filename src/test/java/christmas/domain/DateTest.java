package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateTest {
    @DisplayName("날짜가 1일 ~ 31일이 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 32, 33, 99})
    @ParameterizedTest
    void wrongDayEx(int day) {
        assertThatThrownBy(() -> new Date(day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 이벤트 기간인지 확인한다.")
    @CsvSource({
            "1, true",
            "25, true",
            "26, false",
            "31, false"
    })
    @ParameterizedTest
    void checkEventPeriod(int day, boolean expected) {
        Date date = new Date(day);
        boolean result = date.isEventPeriod(1, 25);
        assertThat(result).isEqualTo(expected);
    }
}
