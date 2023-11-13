package christmas.view;

import java.util.Arrays;
import java.util.List;

public class InputViewConvertor {
    private static final String SEPARATOR = ",";

    public int convertToDate(String input) {
        return Integer.parseInt(input);
    }

    public List<String> convertToOrderInfo(String input) {
        return Arrays.stream(input.split(SEPARATOR)).toList();
    }
}
