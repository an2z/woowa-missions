package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.Reservation;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class EventController {
    private static final String ORDER_INFO_SEPARATOR = "-";

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final EventPlanner eventPlanner = new EventPlanner();

    public void run() {
        outputView.showGreeting();
        Date date = new Date(inputView.readDate());
        Orders orders = makeOrders(inputView.readOrderInfo());

        Reservation reservation = new Reservation(date, orders);
        reservation.calculateTotalOrderPrice();
        outputView.showReservationInfo(reservation);

        Map<Event, Integer> benefitsByEvent = eventPlanner.findBenefitsByEvent(reservation);
        eventPlanner.findGiftMenu();
        outputView.showBenefits(benefitsByEvent);
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
