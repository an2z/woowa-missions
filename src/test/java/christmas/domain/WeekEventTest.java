package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeekEventTest {
    WeekEvent weekEvent;

    @BeforeEach
    void setUp() {
        weekEvent = new WeekEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31)
        );
    }

    @DisplayName("방문 요일이 주말일 경우 주문한 메인 메뉴 개수에 따라 할인 금액을 계산한다.")
    @CsvSource({
            "1, 2023",
            "2, 4046",
            "3, 6069"
    })
    @ParameterizedTest
    void calculateWeekendDiscount(int count, int expected) {
        //given
        Date weekend = new Date(2);
        Orders orders = new Orders(List.of(new Order(Menu.BBQ_RIBS, count)));
        Reservation reservation = new Reservation(weekend, orders);

        //when
        int discount = weekEvent.calculateDiscount(reservation);

        //then
        assertThat(discount).isEqualTo(expected);
    }
}
