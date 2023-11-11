package christmas.view;

import christmas.domain.Reservation;

public class OutputView {
    private static final String GREETING = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE = "<할인 전 총주문 금액>";
    private static final String LINE_BREAK = "\n";
    private static final String ORDER_MENU_FORMAT = "%s %d개";
    private static final String PRICE_FORMAT = "%,d원";

    public void showGreeting() {
        System.out.println(GREETING);
    }

    public static void showError(String message) {
        System.out.println(message);
    }

    public void showReservationInfo(Reservation reservation) {
        System.out.println(String.format(EVENT_PREVIEW, reservation.getVisitDate().getDay()));
        System.out.print(LINE_BREAK);

        System.out.println(ORDER_MENU);
        reservation.getOrders().stream()
                .map(order -> String.format(ORDER_MENU_FORMAT, order.getMenu().getName(), order.getCount()))
                .forEach(System.out::println);
        System.out.print(LINE_BREAK);

        System.out.println(TOTAL_ORDER_PRICE);
        System.out.println(String.format(PRICE_FORMAT, reservation.getTotalOrderPrice()));
        System.out.print(LINE_BREAK);
    }
}
