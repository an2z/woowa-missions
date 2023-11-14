package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;

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

    @DisplayName("방문 날짜에 따른 할인 금액을 계산한다.")
    @CsvSource({"1, 1000", "2, 1100", "3, 1200", "25, 3400"})
    @ParameterizedTest
    void calculateDiscount(int day, int expected) {
        //given
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(day);
        Orders orders = new Orders(List.of(new Order(Menu.TAPAS, 1)));
        Reservation reservation = new Reservation(visitDate, orders);

        //when
        int discount = christmasEvent.calculateDiscount(reservation);

        //then
        assertThat(discount).isEqualTo(expected);
    }
}
