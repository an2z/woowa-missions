package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (isWrongSize(numbers.size())) {
            throw new IllegalArgumentException("[ERROR] 3자리의 숫자만 가능합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException("[ERROR] 각 자리 숫자는 1부터 9까지의 숫자만 가능합니다.");
            }
        }
    }

    private boolean isWrongSize(int size) {
        return size != 3;
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || 9 < number;
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
