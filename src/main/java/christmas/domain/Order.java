package christmas.domain;

public class Order {
    private static final int MIN_COUNT = 1;
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    public static Order from(String menuName, int count) {
        return new Order(Menu.find(menuName), count);
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }

    public boolean isDrinkMenu() {
        return menu.isDrink();
    }

    public boolean isMainMenu() {
        return menu.isMain();
    }

    public int calculatePrice() {
        return menu.calculatePrice(count);
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
