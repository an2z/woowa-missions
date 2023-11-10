package christmas.domain;

public class OrderMenu {
    private static final int MIN_COUNT = 1;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Menu menu;
    private final int count;

    public OrderMenu(Menu menu, int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    public static OrderMenu from(String menuName, int count) {
        return new OrderMenu(Menu.find(menuName), count);
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    public int getCount() {
        return count;
    }
}
