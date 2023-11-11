package christmas.domain;

import java.time.LocalDate;

public class SpecialEvent implements Event {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public SpecialEvent(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    @Override
    public int calculateDiscount() {
        return 0;
    }
}
