package christmas.view;

import christmas.domain.Event;
import christmas.domain.EventBadge;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Reservation;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String ORDER_TITLE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU_TITLE = "<증정 메뉴>";
    private static final String BENEFIT_TITLE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_AMOUNT_TITLE = "<총혜택 금액>";
    private static final String PAYMENT_TITLE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_TITLE = "<12월 이벤트 배지>";

    private static final String GREETING_FORMAT = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW_FORMAT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_FORMAT = "%s %d개";
    private static final String GIFT_FORMAT = "%s 1개";
    private static final String PRICE_FORMAT = "%,d원";
    private static final String BENEFIT_FORMAT = "%s: -%,d원";
    private static final String MINUS = "-";
    private static final String NONE = "없음";

    public void showGreeting() {
        System.out.println(GREETING_FORMAT);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showReservationInfo(Reservation reservation) {
        showPreview(reservation.getVisitDate().getDate().getDayOfMonth());
        showOrders(reservation.getOrders());
        showTotalOrderPrice(reservation.getTotalOrderPrice());
    }

    private void showPreview(int date) {
        String formattedPreview = format(PREVIEW_FORMAT, date);
        System.out.println(formattedPreview + LINE_SEPARATOR);
    }

    private void showOrders(List<Order> orders) {
        System.out.println(ORDER_TITLE);
        orders.stream()
                .map(order -> format(ORDER_FORMAT, order.getMenuName(), order.getCount()))
                .forEach(System.out::println);
        System.out.print(LINE_SEPARATOR);
    }

    private void showTotalOrderPrice(int totalOrderPrice) {
        System.out.println(TOTAL_ORDER_PRICE_TITLE);
        String formattedPrice = format(PRICE_FORMAT, totalOrderPrice);
        System.out.println(formattedPrice + LINE_SEPARATOR);
    }

    public void showGift(Optional<Menu> giftMenu) {
        System.out.println(GIFT_MENU_TITLE);
        String output = NONE;
        if (giftMenu.isPresent()) {
            output = format(GIFT_FORMAT, giftMenu.get().getName());
        }
        System.out.println(output + LINE_SEPARATOR);
    }

    public void showBenefits(Map<Event, Integer> benefits, int totalBenefitPrice) {
        showBenefitInfo(benefits);
        showTotalBenefitPrice(totalBenefitPrice);
    }

    private void showBenefitInfo(Map<Event, Integer> benefits) {
        System.out.println(BENEFIT_TITLE);
        if (benefits.isEmpty()) {
            System.out.println(NONE + LINE_SEPARATOR);
            return;
        }
        for (Map.Entry<Event, Integer> entry : benefits.entrySet()) {
            String eventName = entry.getKey().getEventName();
            int benefitAmount = entry.getValue();
            System.out.println(format(BENEFIT_FORMAT, eventName, benefitAmount));
        }
        System.out.print(LINE_SEPARATOR);
    }

    private void showTotalBenefitPrice(int totalBenefitPrice) {
        System.out.println(TOTAL_BENEFIT_AMOUNT_TITLE);
        String output = format(PRICE_FORMAT, totalBenefitPrice);
        if (totalBenefitPrice > 0) {
            output = MINUS + output;
        }
        System.out.println(output + LINE_SEPARATOR);
    }

    public void showPayment(int payment) {
        System.out.println(PAYMENT_TITLE);
        String formattedPayment = format(PRICE_FORMAT, payment);
        System.out.println(formattedPayment + LINE_SEPARATOR);
    }

    public void showBadge(EventBadge eventBadge) {
        System.out.println(BADGE_TITLE);
        System.out.println(eventBadge.getName());
    }

    private String format(String format, Object... args) {
        return String.format(format, args);
    }
}
