package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class EventStore {
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int FIRST_DAY = 1;
    private static final int LAST_DAY = 31;
    private static final int CHRISTMAS_DAY = 25;
    private static final LocalDate START_DATE = LocalDate.of(YEAR, MONTH, FIRST_DAY);
    private static final LocalDate END_DATE = LocalDate.of(YEAR, MONTH, LAST_DAY);
    private static final LocalDate CHRISTMAS_DATE = LocalDate.of(YEAR, MONTH, CHRISTMAS_DAY);

    private final List<Event> events;

    public EventStore() {
        this.events = List.of(
                new ChristmasEvent(START_DATE, CHRISTMAS_DATE),
                new WeekEvent(START_DATE, END_DATE),
                new SpecialEvent(START_DATE, END_DATE),
                new GiftEvent(START_DATE, END_DATE)
        );
    }

    public List<Event> findOngoingEvents(LocalDate visitDate) {
        return events.stream()
                .filter(event -> event.isDateWithinPeriod(visitDate))
                .toList();
    }
}
