package christmas.domain;

import java.time.LocalDate;

public class WeekEvent extends Event {
    private static final int DEFAULT_DISCOUNT = 2023;

    public WeekEvent(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        eventType = EventType.WEEKDAY_EVENT;
        Menu.Category category = Menu.Category.DESSERT;

        if (reservation.isVisitOnWeekend()) {
            eventType = EventType.WEEKEND_EVENT;
            category = Menu.Category.MAIN;
        }

        return DEFAULT_DISCOUNT * reservation.countMenuOfCategory(category);
    }
}
