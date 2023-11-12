package christmas.domain;

import java.time.LocalDate;

public interface Event {
    boolean isDateWithinPeriod(LocalDate visitDate);

    int calculateDiscount(Reservation reservation);

    String getEventName();
}
