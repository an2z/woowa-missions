package christmas.view;

import java.util.Arrays;
import java.util.List;

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

    public List<String[]> convertToValidatedOrderInfos(String input) {
        validator.validateOrderInfo(input);
        return Arrays.stream(input.split(ORDER_SEPARATOR))
                .map(orderInfo -> orderInfo.split(ORDER_INFO_SEPARATOR))
                .toList();
    }
}
