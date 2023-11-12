package christmas.domain;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EventPlanner {
    private static final int MIN_ORDER_PRICE = 10000;

    private final EventStore eventStore;
    private final Map<Event, Integer> benefitsByEvent;

    public EventPlanner() {
        eventStore = new EventStore();
        benefitsByEvent = new HashMap<>();
    }

    public Map<Event, Integer> findBenefitsByEvent(Reservation reservation) {
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

    public Optional<Menu> findGiftMenu() {
        for (Event event : benefitsByEvent.keySet()) {
            if (event instanceof GiftEvent giftEvent) {
                return Optional.of(giftEvent.getGiftMenu());
            }
        }
        return Optional.empty();
    }
}
