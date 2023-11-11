package christmas.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventStore {
    private List<Event> events = new ArrayList<>();

    public void storeEvent() {
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate lastDate = LocalDate.of(2023, 12, 31);
        LocalDate christmasDate = LocalDate.of(2023, 12, 25);
        events.add(new ChristmasEvent(startDate, christmasDate));
        events.add(new WeekEvent(startDate, lastDate));
        events.add(new SpecialEvent(startDate, lastDate));
    }
}
