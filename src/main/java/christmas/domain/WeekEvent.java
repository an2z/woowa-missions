package christmas.domain;

import java.time.LocalDate;

public class WeekEvent implements Event {
    private static final int DEFAULT_DISCOUNT = 2023;

    private final LocalDate startDate;
    private final LocalDate endDate;

    private EventType eventType;

    public WeekEvent(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
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

    @Override
    public String getEventName() {
        return eventType.getName();
    }
}
