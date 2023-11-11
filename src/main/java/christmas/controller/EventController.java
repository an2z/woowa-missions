package christmas.controller;

import christmas.domain.Date;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
    private static final String ORDER_INFO_SEPARATOR = "-";

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.showGreeting();
        Date date = new Date(inputView.readDate());
        OrderMenus orderMenus = makeOrderMenus(inputView.readOrderMenus());
    }

    private OrderMenus makeOrderMenus(List<String> input) {
        return new OrderMenus(makeOrderMenu(input));
    }

    private List<OrderMenu> makeOrderMenu(List<String> input) {
        return input.stream()
                .map(menu -> {
                    String[] result = menu.split(ORDER_INFO_SEPARATOR);
                    return OrderMenu.from(result[0], Integer.parseInt(result[1]));
                })
                .toList();
    }
}
