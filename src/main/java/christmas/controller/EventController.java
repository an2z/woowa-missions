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
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final EventPlanner eventPlanner = new EventPlanner();

    public void run() {
        outputView.showGreeting();
        Date date = makeCorrectDate();
        Orders orders = makeCorrectOrders();
        Reservation reservation = new Reservation(date, orders);
        outputView.showReservationInfo(reservation);

        Map<Event, Integer> benefits = eventPlanner.findBenefits(reservation);
        int totalBenefitAmount = eventPlanner.calculateTotalBenefitAmount();
        outputView.showGift(eventPlanner.findGiftMenu());
        outputView.showBenefits(benefits, totalBenefitAmount);

        outputView.showPayment(reservation.calculatePayment(totalBenefitAmount));
        outputView.showBadge(EventBadge.find(totalBenefitAmount));
    }

    private Date makeCorrectDate() {
        try {
            return Date.from(inputView.readDate());
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

    private Orders makeOrders(Map<String, Integer> orderInfo) {
        List<Order> orders = orderInfo.entrySet().stream()
                .map(entry -> Order.from(entry.getKey(), entry.getValue()))
                .toList();
        return new Orders(orders);
    }
}
