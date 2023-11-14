package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    private final Date visitDate;
    private final Orders orders;
    private final int totalOrderPrice;

    public Reservation(Date visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.totalOrderPrice = calculateTotalOrderPrice();
    }

    public int calculateTotalOrderPrice() {
        return orders.calculateTotalPrice();
    }

    public int calculatePayment(int totalBenefits) {
        return totalOrderPrice - totalBenefits;
    }

    public boolean isSpecialDay(List<Integer> specialDays) {
        return visitDate.isSpecialDay(specialDays);
    }

    public boolean isLargerOrderPrice(int minOrderPrice) {
        return totalOrderPrice > minOrderPrice;
    }

    public boolean isVisitOnWeekend() {
        return visitDate.isWeekend();
    }

    public int countMenuOfCategory(Menu.Category category) {
        return orders.countMenuOfCategory(category);
    }

    public int getDaysSinceStart(LocalDate startDate) {
        return visitDate.getDaysSinceStart(startDate);
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
