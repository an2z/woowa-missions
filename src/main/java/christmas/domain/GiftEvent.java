package christmas.domain;

import java.time.LocalDate;
import java.util.Optional;

public class GiftEvent implements Event {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int NO_DISCOUNT = 0;
    private static final int MIN_ORDER_PRICE = 120000;

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final EventType eventType;
    private final Menu giftMenu;

    public GiftEvent(LocalDate startDate, LocalDate endDate, EventType eventType, Menu giftMenu) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = eventType;
        this.giftMenu = giftMenu;
    }

    public Optional<Menu> getGiftMenu(Reservation reservation) {
        if (isEventPeriod(reservation) && isGiftCondition(reservation)) {
            return Optional.of(Menu.CHAMPAGNE);
        }
        return Optional.empty();
    }

    private boolean isEventPeriod(Reservation reservation) {
        return reservation.isEventPeriod(START_DATE, END_DATE);
    }

    private boolean isGiftCondition(Reservation reservation) {
        return reservation.calculateTotalOrderPrice() >= MIN_ORDER_PRICE;
    }

    @Override
    public boolean isDateWithinPeriod(LocalDate visitDate) {
        return !visitDate.isBefore(startDate) && !visitDate.isAfter(endDate);
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        if (reservation.isLargerOrderPrice(MIN_ORDER_PRICE)) {
            return giftMenu.getPrice();
        }
        return NO_DISCOUNT;
    }

    @Override
    public String getEventName() {
        return eventType.getName();
    }

    public Menu getGiftMenu() {
        return giftMenu;
    }
}
