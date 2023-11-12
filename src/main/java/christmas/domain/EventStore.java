package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventStore {
    private List<Event> events = new ArrayList<>();

    public EventStore() {
        LocalDate lastDate = LocalDate.of(2023, 12, 31);
        LocalDate christmasDate = LocalDate.of(2023, 12, 25);
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        events.add(new ChristmasEvent(startDate, christmasDate, EventType.CHRISTMAS_EVENT));
        events.add(new WeekEvent(startDate, lastDate));
        events.add(new SpecialEvent(startDate, lastDate, EventType.SPECIAL_EVENT, List.of(3, 10, 17, 24, 25, 31)));
        events.add(new GiftEvent(startDate, lastDate, EventType.GIFT_EVENT, Menu.CHAMPAGNE));
    }

    public List<Event> findOngoingEvents(LocalDate visitDate) {
        return events.stream()
                .filter(event -> event.isDateWithinPeriod(visitDate))
                .toList();
    }
}
