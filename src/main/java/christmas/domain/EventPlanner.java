package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class EventPlanner {
    private final EventStore eventStore = new EventStore();

    public List<Event> findOngoingEvents(Reservation reservation) {
        LocalDate visitDate = LocalDate.of(2023, 12, reservation.getVisitDate().getDay());
        return eventStore.findOngoingEvents(visitDate);
    }
}
