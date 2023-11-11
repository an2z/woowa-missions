package christmas.domain;

import java.util.List;

public class Reservation {
    private static final int GIFT_CONDITION = 120000;

    private final Date visitDate;
    private final Orders orders;

    private int totalOrderPrice;

    public Reservation(Date visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.orders = orders;
    }

    public int calculateTotalOrderPrice() {
        totalOrderPrice = orders.calculateTotalPrice();
        return totalOrderPrice;
    }

    public boolean isEventPeriod(int startDate, int endDate) {
        return visitDate.isEventPeriod(startDate, endDate);
    }

    public int getDayGap(int day) {
        return visitDate.getDayGap(day);
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public List<Order> getOrders() {
        return orders.getOrders();
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
