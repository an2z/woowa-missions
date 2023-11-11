package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.Orders;
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
        Orders orders = makeOrders(inputView.readOrderInfo());
    }

    private Orders makeOrders(List<String> orderInfo) {
        List<Order> orders = orderInfo.stream()
                .map(menu -> {
                    String[] result = menu.split(ORDER_INFO_SEPARATOR);
                    return Order.from(result[0], Integer.parseInt(result[1]));
                })
                .toList();
        return new Orders(orders);
    }
}
