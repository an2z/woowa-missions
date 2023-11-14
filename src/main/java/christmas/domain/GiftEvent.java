package christmas.domain;

import java.time.LocalDate;

public class GiftEvent extends Event {
    private static final int NO_DISCOUNT = 0;
    private static final int MIN_ORDER_PRICE = 120000;

    private final Menu giftMenu;

    public GiftEvent(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
        this.eventType = EventType.GIFT_EVENT;
        this.giftMenu = Menu.CHAMPAGNE;
    }

    @Override
    public int calculateDiscount(Reservation reservation) {
        if (reservation.isLargerOrderPrice(MIN_ORDER_PRICE)) {
            return giftMenu.getPrice();
        }
        return NO_DISCOUNT;
    }

    public Menu getGiftMenu() {
        return giftMenu;
    }
}
