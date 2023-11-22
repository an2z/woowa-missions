package christmas.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orders {
    private static final int MAX_TOTAL_COUNT = 20;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validate(orders);
        this.orders = orders;
    }

    private void validate(List<Order> orders) {
        validateDuplicate(orders);
        validateTotalCount(orders);
        validateMenuCategory(orders);
    }

    private void validateDuplicate(List<Order> orders) {
        if (isDuplicated(orders)) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicated(List<Order> orders) {
        Set<String> menuNames = new HashSet<>();
        return orders.stream()
                .map(Order::getMenuName)
                .anyMatch(menuName -> !menuNames.add(menuName));
    }

    private void validateTotalCount(List<Order> orders) {
        if (calculateTotalCount(orders) > MAX_TOTAL_COUNT) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private int calculateTotalCount(List<Order> orders) {
        return orders.stream()
                .map(Order::getCount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateMenuCategory(List<Order> orders) {
        if (isAllDrinkMenu(orders)) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private boolean isAllDrinkMenu(List<Order> orders) {
        return orders.stream()
                .allMatch(order -> order.isMenuOfCategory(Menu.Category.DRINK));
    }

    public int countMenuOfCategory(Menu.Category category) {
        return orders.stream()
                .filter(order -> order.isMenuOfCategory(category))
                .map(Order::getCount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .map(Order::calculatePrice)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
