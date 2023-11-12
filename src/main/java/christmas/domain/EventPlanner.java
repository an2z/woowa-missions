package christmas.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPlanner {
    private static final int MIN_ORDER_PRICE = 10000;

    private final EventStore eventStore = new EventStore();

    public Map<Event, Integer> findBenefitsByEvent(Reservation reservation) {
        Map<Event, Integer> benefitsByEvent = new HashMap<>();

        if (canNotParticipate(reservation)) {
            return benefitsByEvent;
        }

        for (Event event : findOngoingEvents(reservation)) {
            int discount = event.calculateDiscount(reservation);
            if (discount > 0) {
                benefitsByEvent.put(event, discount);
            }
        }
        return benefitsByEvent;
    }

    private boolean canNotParticipate(Reservation reservation) {
        return !reservation.isLargerOrderPrice(MIN_ORDER_PRICE);
    }

    private List<Event> findOngoingEvents(Reservation reservation) {
        LocalDate visitDate = LocalDate.of(2023, 12, reservation.getVisitDate().getDay());
        return eventStore.findOngoingEvents(visitDate);
    }
}
