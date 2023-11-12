package christmas.domain;

import java.time.LocalDate;

public class ChristmasEvent implements Event {
    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int EXTRA_DISCOUNT = 100;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final EventType eventType;

    public ChristmasEvent(LocalDate startDate, LocalDate endDate, EventType eventType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
    }

    @Override
    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        int dayGap = reservation.getDayGap(startDate.getDayOfMonth());
        return DEFAULT_DISCOUNT + EXTRA_DISCOUNT * dayGap;
    }
}
