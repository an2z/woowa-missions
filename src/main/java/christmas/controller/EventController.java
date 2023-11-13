package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Event;
import christmas.domain.EventBadge;
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
        Date date = makeCorrectDate();
        Orders orders = makeCorrectOrders();

        Reservation reservation = new Reservation(date, orders);
        outputView.showReservationInfo(reservation);

        Map<Event, Integer> benefitsByEvent = eventPlanner.findBenefitsByEvent(reservation);
        outputView.showGift(eventPlanner.findGiftMenu());
        outputView.showBenefits(benefitsByEvent);
        int totalBenefits = eventPlanner.calculateTotalBenefit();
        outputView.showTotalBenefits(totalBenefits);
        outputView.showPayment(reservation.calculatePayment(totalBenefits));
        outputView.showBadge(EventBadge.find(totalBenefits));
    }

    private Date makeCorrectDate() {
        try {
            return new Date(inputView.readDate());
        } catch (IllegalArgumentException e) {
            outputView.showError(e.getMessage());
            return makeCorrectDate();
        }
    }

    private Orders makeCorrectOrders() {
        try {
            return makeOrders(inputView.readOrderInfo());
        } catch (IllegalArgumentException e) {
            outputView.showError(e.getMessage());
            return makeCorrectOrders();
        }
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
