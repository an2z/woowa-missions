package christmas.domain;

import java.time.LocalDate;

public class WeekEvent extends Event {
    private static final int DEFAULT_DISCOUNT = 2023;

    public WeekEvent(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        if (reservation.isVisitOnWeekend()) {
            eventType = EventType.WEEKEND_EVENT;
            return DEFAULT_DISCOUNT * reservation.countMainMenu();
        }
        eventType = EventType.WEEKDAY_EVENT;
        return DEFAULT_DISCOUNT * reservation.countDessertMenu();
    }
}
