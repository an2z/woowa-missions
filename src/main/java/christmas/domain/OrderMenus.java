package christmas.domain;

import java.util.List;

public class OrderMenus {
    private static final int MAX_TOTAL_COUNT = 20;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final List<OrderMenu> menus;

    public OrderMenus(List<OrderMenu> menus) {
        validateTotalCount(menus);
        validateMenuCategory(menus);
        this.menus = menus;
    }

    private void validateTotalCount(List<OrderMenu> menus) {
        if (calculateTotalCount(menus) > MAX_TOTAL_COUNT) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private int calculateTotalCount(List<OrderMenu> menus) {
        return menus.stream()
                .map(OrderMenu::getCount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void validateMenuCategory(List<OrderMenu> menus) {
        if (calculateDrinkCount(menus) == menus.size()) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    private long calculateDrinkCount(List<OrderMenu> menus) {
        return menus.stream()
                .filter(OrderMenu::isDrinkMenu)
                .count();
    }
}
