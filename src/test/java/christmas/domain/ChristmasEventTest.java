package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasEventTest {
    ChristmasEvent christmasEvent;

    @BeforeEach
    void setUp() {
        christmasEvent = new ChristmasEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 25)
        );
    }

    @DisplayName("방문 날짜가 크리스마스 디데이 이벤트 진행 기간인지 확인한다.")
    @CsvSource({"1, true", "25, true", "26, false"})
    @ParameterizedTest
    void checkPeriod(int day, boolean expected) {
        LocalDate visitDate = LocalDate.of(2023, 12, day);
        boolean result = christmasEvent.isDateWithinPeriod(visitDate);
        assertThat(result).isEqualTo(expected);
    }
}
