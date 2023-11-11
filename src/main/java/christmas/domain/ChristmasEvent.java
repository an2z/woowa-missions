package christmas.domain;

import java.time.LocalDate;

public class ChristmasEvent implements Event {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public ChristmasEvent(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public int calculateDiscount() {
        return 0;
    }
}
