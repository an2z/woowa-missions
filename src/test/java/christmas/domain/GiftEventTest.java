package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class GiftEventTest {
    GiftEvent giftEvent = new GiftEvent();

    @DisplayName("방문 날짜가 이벤트 기간에 해당하고, 총 주문 금액이 120000원 이상일 경우에 증정 메뉴가 존재한다.")
    @CsvSource({"10, true", "1, false",})
    @ParameterizedTest
    void giftMenu(int count, boolean expected) {
        // given
        Date visitDate = new Date(1);
        OrderMenus orderMenus = new OrderMenus(List.of(new OrderMenu(Menu.BBQ_RIBS, count)));
        Reservation reservation = new Reservation(visitDate, orderMenus);

        // when
        Optional<Menu> giftMenu = giftEvent.getGiftMenu(reservation);

        // then
        assertThat(giftMenu.isPresent()).isEqualTo(expected);
    }
}
