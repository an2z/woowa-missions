package christmas.domain;

import java.time.LocalDate;

public abstract class Event {
    protected final LocalDate startDate;
    protected final LocalDate endDate;

    protected EventType eventType;

    protected Event(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    public String getEventName() {
        return eventType.getName();
    }

    public abstract int calculateDiscount(Reservation reservation);
}
