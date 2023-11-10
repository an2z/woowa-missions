package christmas.domain;

public class OrderMenu {
    private final Menu menu;
    private final int count;

    private OrderMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public static OrderMenu from(String menuName, int count) {
        return new OrderMenu(Menu.find(menuName), count);
    }
}
