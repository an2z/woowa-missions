package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialEventTest {
    SpecialEvent specialEvent;

    @BeforeEach
    void setUp() {
        specialEvent = new SpecialEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31)
        );
    }

    @DisplayName("방문 날짜가 특별 이벤트 진행 기간인지 확인한다.")
    @ValueSource(ints = {1, 25, 30, 31})
    @ParameterizedTest
    void checkPeriod(int day) {
        LocalDate visitDate = LocalDate.of(2023, 12, day);
        boolean result = specialEvent.isDateWithinPeriod(visitDate);
        assertThat(result).isTrue();
    }

    @DisplayName("방문 날짜가 별 날짜일 경우 1000원, 아닐 경우 0원 할인된다.")
    @CsvSource({
            "3, 1000",
            "10, 1000",
            "17, 1000",
            "24, 1000",
            "25, 1000",
            "31, 1000",
            "11, 0",
            "30, 0"
    })
    @ParameterizedTest
    void calculateDiscount(int day, int expected) {
        //given
        VisitDate visitDate = VisitDate.makeEventVisitDate(day);
        Orders orders = new Orders(List.of(new Order(Menu.TAPAS, 1)));
        Reservation reservation = new Reservation(visitDate, orders);

        //when
        int discount = specialEvent.calculateDiscount(reservation);

        //then
        assertThat(discount).isEqualTo(expected);
    }
}
