package christmas.domain;

public class Reservation {
    private static final int GIFT_CONDITION = 120000;

    private final Date visitDate;
    private final OrderMenus orderMenus;

    private int totalOrderPrice;

    public Reservation(Date visitDate, OrderMenus orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }

    public int calculateTotalOrderPrice() {
        totalOrderPrice = orderMenus.calculateTotalPrice();
        return totalOrderPrice;
    }

    public boolean isEventPeriod(int startDate, int endDate) {
        return visitDate.isEventPeriod(startDate, endDate);
    }
}
