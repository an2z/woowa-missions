package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EventPlannerTest {
    EventPlanner eventPlanner = new EventPlanner();

    @DisplayName("총 혜택 금액을 계산한다.")
    @Test
    void calculateTotalBenefitAmount() {
        // given
        VisitDate visitDate = VisitDate.from(3);
        Orders orders = new Orders(List.of(
                new Order(Menu.TAPAS, 1),
                new Order(Menu.ZERO_COLA, 1)
        ));
        Reservation reservation = new Reservation(visitDate, orders);
        eventPlanner.findBenefits(reservation);

        // when
        int totalBenefit = eventPlanner.calculateTotalBenefitAmount();

        // then
        assertThat(totalBenefit).isZero();
    }
}
