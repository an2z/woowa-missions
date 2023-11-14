package christmas.domain;

import java.util.List;

public class Orders {
    private static final int MAX_TOTAL_COUNT = 20;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateTotalCount(orders);
        validateMenuCategory(orders);
        this.orders = orders;
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
        return orders.stream().allMatch(Order::isDrinkMenu);
    }

    public int countMainMenu() {
        //TODO 티본스테이크-2, 바비큐립-1 주문 시 주말 할인이 들어가는 메인 메뉴의 개수가 3개? 2개? 우선 3개로 처리
        return orders.stream()
                .filter(Order::isMainMenu)
                .map(Order::getCount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int countDessertMenu() {
        return orders.stream()
                .filter(Order::isDessertMenu)
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
