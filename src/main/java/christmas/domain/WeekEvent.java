package christmas.domain;

import java.time.LocalDate;

public class WeekEvent implements Event {
    private static final int DEFAULT_DISCOUNT = 2023;

    private final LocalDate startDate;
    private final LocalDate endDate;

    public WeekEvent(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    public int calculateDiscount(Reservation reservation) {
        if (reservation.isVisitOnWeekend()) {
            return DEFAULT_DISCOUNT * reservation.countMainMenu();
        }
        //TODO 평일 할인 계산 로직 구현
        return DEFAULT_DISCOUNT;
    }

    @Override
    public int calculateDiscount() {
        return 0;
    }
}
