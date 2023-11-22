package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class SpecialEvent extends Event {
    private static final int NO_DISCOUNT = 0;
    private static final int DEFAULT_DISCOUNT = 1000;

    private final List<Integer> specialDays;

    public SpecialEvent(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
        this.eventType = EventType.SPECIAL_EVENT;
        this.specialDays = List.of(3, 10, 17, 24, 25, 31);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        if (reservation.isSpecialDay(specialDays)) {
            return DEFAULT_DISCOUNT;
        }
        return NO_DISCOUNT;
    }
}
