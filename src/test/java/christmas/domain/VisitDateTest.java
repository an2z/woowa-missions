package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class VisitDateTest {
    @DisplayName("방문 날짜가 1일 ~ 31일이 아닐 경우 예외가 발생한다.")
    @ValueSource(ints = {0, 32, 33, 99})
    @ParameterizedTest
    void makeInvalidVisitDate(int day) {
        assertThatThrownBy(() -> VisitDate.makeDecemberVisitDate(day))
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
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(day);
        boolean result = visitDate.isSpecialDay(List.of(3, 10, 17, 24, 25, 31));
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("방문 날짜가 주말인지 확인한다.")
    @CsvSource({
            "2, true",
            "8, true",
            "15, true",
            "6, false",
            "25, false",
            "27, false"
    })
    @ParameterizedTest
    void checkWeekend(int day, boolean expected) {
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(day);
        boolean result = visitDate.isWeekend();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("방문 날짜가 시작일로부터 몇일이 지났는지 구한다.")
    @CsvSource({
            "1, 0",
            "2, 1",
            "3, 2",
            "4, 3"
    })
    @ParameterizedTest
    void getDaysSinceStart(int day, int expected) {
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(day);
        int result = visitDate.getDaysSinceStart(LocalDate.of(2023, 12, 1));
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("같은 날짜를 가진 방문 날짜의 동등성을 비교한다.")
    @Test
    void checkEqualsAndHashCode() {
        VisitDate visitDate1 = VisitDate.makeDecemberVisitDate(1);
        VisitDate visitDate2 = VisitDate.makeDecemberVisitDate(1);
        VisitDate visitDate3 = VisitDate.makeDecemberVisitDate(2);
        assertThat(visitDate1)
                .isEqualTo(visitDate2)
                .hasSameHashCodeAs(visitDate2)
                .isNotEqualTo(visitDate3)
                .doesNotHaveSameHashCodeAs(visitDate3);
    }
}
