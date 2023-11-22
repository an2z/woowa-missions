package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class EventPlannerTest {
    EventPlanner eventPlanner = new EventPlanner();

    @DisplayName("총 혜택 금액을 계산한다.")
    @Test
    void calculateTotalBenefitPrice() {
        // given
        VisitDate visitDate = VisitDate.makeEventVisitDate(3);
        Orders orders = new Orders(List.of(
                new Order(Menu.TAPAS, 1),
                new Order(Menu.ZERO_COLA, 1)
        ));
        Reservation reservation = new Reservation(visitDate, orders);
        eventPlanner.findBenefits(reservation);

        // when
        int totalBenefit = eventPlanner.calculateTotalBenefitPrice();

        // then
        assertThat(totalBenefit).isZero();
    }

    @DisplayName("총 할인 금액을 계산한다.")
    @Test
    void calculateTotalDiscountPrice() {
        // given
        VisitDate visitDate = VisitDate.makeEventVisitDate(3);
        Orders orders = new Orders(List.of(
                new Order(Menu.T_BONE_STEAK, 1),
                new Order(Menu.BBQ_RIBS, 1),
                new Order(Menu.CHOCO_CAKE, 2),
                new Order(Menu.ZERO_COLA, 1)
        ));
        Reservation reservation = new Reservation(visitDate, orders);
        eventPlanner.findBenefits(reservation);

        // when
        int discount = eventPlanner.calculateTotalDiscountPrice();

        // then
        assertThat(discount).isEqualTo(6246);
    }

    @DisplayName("증정 메뉴를 확인한다.")
    @CsvSource({"1, false", "20, true"})
    @ParameterizedTest
    void findGiftMenu(int count, boolean expected) {
        // given
        VisitDate visitDate = VisitDate.makeEventVisitDate(3);
        Orders orders = new Orders(List.of(new Order(Menu.T_BONE_STEAK, count)));
        Reservation reservation = new Reservation(visitDate, orders);
        eventPlanner.findBenefits(reservation);

        // when
        Optional<Menu> giftMenu = eventPlanner.findGiftMenu();

        // then
        assertThat(giftMenu.isPresent()).isEqualTo(expected);
    }
}
