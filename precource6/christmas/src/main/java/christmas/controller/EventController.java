package christmas.controller;

import christmas.domain.Event;
import christmas.domain.EventBadge;
import christmas.domain.EventPlanner;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
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
        Reservation reservation = makeReservation();
        outputView.showReservationInfo(reservation);

        Map<Event, Integer> benefits = eventPlanner.findBenefits(reservation);
        int totalBenefitPrice = eventPlanner.calculateTotalBenefitPrice();
        int totalDiscountPrice = eventPlanner.calculateTotalDiscountPrice();
        outputView.showGift(eventPlanner.findGiftMenu());
        outputView.showBenefits(benefits, totalBenefitPrice);

        outputView.showPayment(reservation.calculatePayment(totalDiscountPrice));
        outputView.showBadge(EventBadge.find(totalBenefitPrice));
    }

    private Reservation makeReservation() {
        VisitDate visitDate = makeCorrectDate();
        Orders orders = makeCorrectOrders();
        return new Reservation(visitDate, orders);
    }

    private VisitDate makeCorrectDate() {
        while (true) {
            try {
                return VisitDate.makeEventVisitDate(inputView.readDate());
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
            }
        }
    }

    private Orders makeCorrectOrders() {
        while (true) {
            try {
                return makeOrders(inputView.readOrderInfos());
            } catch (IllegalArgumentException e) {
                outputView.showError(e.getMessage());
            }
        }
    }

    private Orders makeOrders(List<String[]> orderInfos) {
        List<Order> orders = orderInfos.stream()
                .map(Order::from)
                .toList();
        return new Orders(orders);
    }
}
