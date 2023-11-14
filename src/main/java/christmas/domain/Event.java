package christmas.domain;

import java.time.LocalDate;

public abstract class Event {
    private static final String EVENT_TYPE_NULL_ERROR = "이벤트 타입이 초기화되지 않았습니다.";

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
        if (eventType == null) {
            throw new IllegalStateException(EVENT_TYPE_NULL_ERROR);
        }
        return eventType.getName();
    }

    public abstract int calculateDiscount(Reservation reservation);
}
