package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {
    public static List<String> convertToList(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .toList();
    }

    private InputConvertor() {
    }
}
