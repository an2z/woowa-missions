package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReservationTest {
    @DisplayName("할인 금액에 따라 예상 결제 금액을 구한다.")
    @CsvSource({
            "1000, 4500",
            "1500, 4000",
            "2000, 3500",
            "2500, 3000",
            "5500, 0"
    })
    @ParameterizedTest
    void calculatePayment(int totalDiscountPrice, int expected) {
        // given
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(1);
        Orders orders = new Orders(List.of(new Order(Menu.TAPAS, 1)));
        Reservation reservation = new Reservation(visitDate, orders);

        // when
        int payment = reservation.calculatePayment(totalDiscountPrice);

        // then
        assertThat(payment).isEqualTo(expected);
    }

    @DisplayName("할인 금액이 총 주문 금액보다 클 경우 예외가 발생한다.")
    @Test
    void calculatePaymentEx() {
        // given
        VisitDate visitDate = VisitDate.makeDecemberVisitDate(1);
        Orders orders = new Orders(List.of(new Order(Menu.TAPAS, 1)));
        Reservation reservation = new Reservation(visitDate, orders);

        // when,then
        assertThatThrownBy(() -> reservation.calculatePayment(6000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
