package christmas.domain;

import java.time.LocalDate;

public class ChristmasEvent extends Event {
    private static final int DEFAULT_DISCOUNT = 1000;
    private static final int EXTRA_DISCOUNT = 100;

    public ChristmasEvent(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
        this.eventType = EventType.CHRISTMAS_EVENT;
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        int days = reservation.getDaysSinceStart(startDate);
        return DEFAULT_DISCOUNT + EXTRA_DISCOUNT * days;
    }
}
