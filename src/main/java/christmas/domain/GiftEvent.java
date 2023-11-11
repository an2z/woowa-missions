package christmas.domain;

import java.util.Optional;

public class GiftEvent {
    private static final int START_DATE = 1;
    private static final int END_DATE = 31;
    private static final int GIFT_CONDITION = 120000;

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
        return reservation.calculateTotalOrderPrice() >= GIFT_CONDITION;
    }
}
