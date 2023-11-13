package christmas.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class InputViewConvertor {
    private static final String ORDER_SEPARATOR = ",";
    private static final String ORDER_INFO_SEPARATOR = "-";

    private final InputViewValidator validator = new InputViewValidator();

    public String convertValidatedInput(String input) {
        validator.validateEmpty(input);
        return input;
    }

    public int convertToValidatedDate(String input) {
        validator.validateDate(input);
        return Integer.parseInt(input);
    }

    public Map<String, Integer> convertToValidatedOrderInfo(String input) {
        validator.validateOrderInfo(input);
        return Arrays.stream(input.split(ORDER_SEPARATOR))
                .map(order -> order.split(ORDER_INFO_SEPARATOR))
                .collect(Collectors.toMap(
                        orderInfo -> orderInfo[0],
                        orderInfo -> {
                            String orderCount = orderInfo[1];
                            validator.validateOrderCount(orderCount);
                            return Integer.parseInt(orderCount);
                        }
                ));
    }
}
