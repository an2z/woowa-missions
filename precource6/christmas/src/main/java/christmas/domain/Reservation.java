package christmas.domain;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    private static final String DISCOUNT_GREATER_THAN_ORDER_PRICE = "[ERROR] 총 할인 금액이 총 주문 금액보다 클 수 없습니다.";

    private final VisitDate visitDate;
    private final Orders orders;
    private final int totalOrderPrice;

    public Reservation(VisitDate visitDate, Orders orders) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.totalOrderPrice = calculateTotalOrderPrice();
    }

    public int calculateTotalOrderPrice() {
        return orders.calculateTotalPrice();
    }

    public int calculatePayment(int totalDiscountPrice) {
        if (totalOrderPrice < totalDiscountPrice) {
            throw new IllegalArgumentException(DISCOUNT_GREATER_THAN_ORDER_PRICE);
        }
        return totalOrderPrice - totalDiscountPrice;
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

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public List<Order> getOrders() {
        return orders.getOrders();
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
