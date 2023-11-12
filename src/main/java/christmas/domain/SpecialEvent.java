package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class SpecialEvent implements Event {
    private static final int NO_DISCOUNT = 0;
    private static final int DEFAULT_DISCOUNT = 1000;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final EventType eventType;
    private final List<Integer> specialDays;

    public SpecialEvent(LocalDate startDate, LocalDate endDate, EventType eventType, List<Integer> specialDays) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.specialDays = specialDays;
    }

    @Override
    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        if (reservation.isSpecialDay(specialDays)) {
            return DEFAULT_DISCOUNT;
        }
        return NO_DISCOUNT;
    }
}
