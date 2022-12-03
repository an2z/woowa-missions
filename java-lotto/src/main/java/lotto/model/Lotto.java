package lotto.model;

import java.util.List;

public class Lotto {
    private static final int DEFAULT_SIZE = 6;
    private static final String SIZE_ERROR = "[ERROR] 로또 번호가 %d개가 아닙니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_ERROR, DEFAULT_SIZE));
        }
    }
}
