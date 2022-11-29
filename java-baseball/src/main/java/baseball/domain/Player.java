package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Player {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBERS_SIZE = 3;
    private static final String SIZE_ERROR = "[ERROR] %d자리 숫자만 가능합니다.";
    private static final String RANGE_ERROR = "[ERROR] 각 자리 숫자는 %d부터 %d까지 숫자만 가능합니다.";
    private static final String DUPLICATION_ERROR = "[ERROR] 각 자리 숫자는 서로 달라야 합니다.";

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean isSamePlace(int place, int number) {
        return numbers.get(place) == number;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (isWrongSize(numbers.size())) {
            throw new IllegalArgumentException(String.format(SIZE_ERROR, NUMBERS_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(String.format(RANGE_ERROR, MIN_NUMBER, MAX_NUMBER));
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isDuplicated(numbers, number)) {
                throw new IllegalArgumentException(DUPLICATION_ERROR);
            }
        }
    }

    private boolean isWrongSize(int size) {
        return size != NUMBERS_SIZE;
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }

    private static boolean isDuplicated(List<Integer> numbers, Integer number) {
        return numbers.indexOf(number) != numbers.lastIndexOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(numbers, player.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
