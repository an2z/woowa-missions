package christmas.domain;

public class Reservation {
    private final Date visitDate;
    private final OrderMenus orderMenus;

    public Reservation(Date visitDate, OrderMenus orderMenus) {
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }
}
