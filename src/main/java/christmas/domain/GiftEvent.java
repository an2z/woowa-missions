package christmas.domain;

import java.time.LocalDate;

public class GiftEvent implements Event {
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
