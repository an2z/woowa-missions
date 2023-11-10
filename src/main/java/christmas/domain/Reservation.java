package christmas.domain;

public class Reservation {
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
}
