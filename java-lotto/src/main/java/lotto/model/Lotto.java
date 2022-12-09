package lotto.model;

import java.util.List;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int DEFAULT_SIZE = 6;
    private static final String SIZE_ERROR = "[ERROR] 로또 번호가 %d개가 아닙니다.";
    private static final String RANGE_ERROR = "[ERROR] 로또 번호에 %d ~ %d 범위를 벗어난 숫자가 존재합니다.";
    private static final String DUPLICATION_ERROR = "[ERROR] 로또 번호에 중복된 숫자가 존재합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_ERROR, DEFAULT_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isValidRange(number)) {
                throw new IllegalArgumentException(String.format(RANGE_ERROR, MIN_NUMBER, MAX_NUMBER));
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isDuplicateNumber(numbers, number)) {
                throw new IllegalArgumentException(DUPLICATION_ERROR);
            }
        }
    }

    private boolean isValidRange(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    private static boolean isDuplicateNumber(List<Integer> numbers, int number) {
        return numbers.indexOf(number) != numbers.lastIndexOf(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
