package christmas.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputViewConvertor {
    private static final String ORDER_SEPARATOR = ",";
    private static final String ORDER_INFO_SEPARATOR = "-";
    private static final String ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public int convertToDate(String input) {
        return Integer.parseInt(input);
    }

    public Map<String, Integer> convertToOrderInfo(String input) {
        return Arrays.stream(input.split(ORDER_SEPARATOR))
                .map(order -> order.split(ORDER_INFO_SEPARATOR))
                .collect(Collectors.toMap(
                        orderInfo -> orderInfo[0],
                        orderInfo -> toInt(orderInfo[1])
                ));
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ORDER_ERROR_MESSAGE);
        }
    }
}
