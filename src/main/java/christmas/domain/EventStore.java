package christmas.domain;

import christmas.utils.Constants;

import java.time.LocalDate;
import java.util.List;

public class EventStore {
    private static final LocalDate START_DATE = LocalDate.of(Constants.EVENT_YEAR, Constants.EVENT_MONTH, 1);
    private static final LocalDate END_DATE = LocalDate.of(Constants.EVENT_YEAR, Constants.EVENT_MONTH, 31);
    private static final LocalDate CHRISTMAS_DATE = LocalDate.of(Constants.EVENT_YEAR, Constants.EVENT_MONTH, 25);

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
