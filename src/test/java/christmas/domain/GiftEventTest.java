package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GiftEventTest {
    GiftEvent giftEvent;

    @BeforeEach
    void setUp() {
        giftEvent = new GiftEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31)
        );
    }

    @DisplayName("방문 날짜가 증정 이벤트 진행 기간인지 확인한다.")
    @ValueSource(ints = {1, 25, 31})
    @ParameterizedTest
    void checkPeriod(int day) {
        LocalDate visitDate = LocalDate.of(2023, 12, day);
        boolean result = giftEvent.isDateWithinPeriod(visitDate);
        assertThat(result).isTrue();
    }

    @DisplayName("총 주문금액이 120000원 이상일 경우 증정메뉴 가격만큼 할인된다.")
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 25000",
            "10, 25000"
    })
    @ParameterizedTest
    void calculateDiscount(int count, int expected) {
        //given
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(1);
        Orders orders = new Orders(List.of(new Order(Menu.BBQ_RIBS, count)));
        Reservation reservation = new Reservation(visitDate, orders);

        //when
        int discount = giftEvent.calculateDiscount(reservation);

        //then
        assertThat(discount).isEqualTo(expected);
    }
}
