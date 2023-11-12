package christmas.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPlanner {
    private final EventStore eventStore = new EventStore();

    public Map<Event, Integer> findBenefitsByEvent(Reservation reservation) {
        Map<Event, Integer> benefitsByEvent = new HashMap<>();
        for (Event event : findOngoingEvents(reservation)) {
            int discount = event.calculateDiscount(reservation);
            if (discount > 0) {
                benefitsByEvent.put(event, discount);
            }
        }
        return benefitsByEvent;
    }

    private List<Event> findOngoingEvents(Reservation reservation) {
        LocalDate visitDate = LocalDate.of(2023, 12, reservation.getVisitDate().getDay());
        return eventStore.findOngoingEvents(visitDate);
    }
}
