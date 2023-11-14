package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VisitDateTest {
    @DisplayName("날짜가 1일 ~ 31일이 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 32, 33, 99})
    @ParameterizedTest
    void wrongDayEx(int day) {
        assertThatThrownBy(() -> VisitDate.from(day))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방문 날짜가 별이 있는 날짜에 해당하는지 확인한다.")
    @CsvSource({
            "3, true",
            "10, true",
            "17, true",
            "4, false",
            "5, false"
    })
    @ParameterizedTest
    void checkSpecialDay(int day, boolean expected) {
        VisitDate visitDate = VisitDate.from(day);
        boolean result = visitDate.isSpecialDay(List.of(3, 10, 17, 24, 25, 31));
        assertThat(result).isEqualTo(expected);
    }
}
