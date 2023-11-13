package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class InputView {
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_INFO_INPUT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private final InputViewConvertor convertor = new InputViewConvertor();

    public int readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        return convertor.convertToValidatedDate(read());
    }

    public Map<String, Integer> readOrderInfo() {
        System.out.println(ORDER_INFO_INPUT_MESSAGE);
        return convertor.convertToValidatedOrderInfo(read());
    }

    private String read() {
        return convertor.convertValidatedInput(Console.readLine());
    }
}
