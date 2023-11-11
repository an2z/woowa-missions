package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU_INPUT_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public int readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        String input = read();
        return Integer.parseInt(input);
    }

    public List<String> readOrderMenus() {
        System.out.println(ORDER_MENU_INPUT_MESSAGE);
        String input = read();
        return convert(input);
    }

    private List<String> convert(String input) {
        return Arrays.stream(input.split(SEPARATOR)).toList();
    }

    private String read() {
        return Console.readLine();
    }
}
