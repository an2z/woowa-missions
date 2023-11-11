package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GiftEventTest {
    GiftEvent giftEvent;

    @BeforeEach
    void setUp() {
        giftEvent = new GiftEvent(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 31),
                Menu.CHAMPAGNE
        );
    }

    @DisplayName("방문 날짜가 이벤트 기간에 해당하고, 총 주문 금액이 120000원 이상일 경우에 증정 메뉴가 존재한다.")
    @CsvSource({"10, true", "1, false"})
    @ParameterizedTest
    void giftMenu(int count, boolean expected) {
        // given
        Date visitDate = new Date(1);
        Orders orders = new Orders(List.of(new Order(Menu.BBQ_RIBS, count)));
        Reservation reservation = new Reservation(visitDate, orders);

        // when
        Optional<Menu> giftMenu = giftEvent.getGiftMenu(reservation);

        // then
        assertThat(giftMenu.isPresent()).isEqualTo(expected);
    }
}
