package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String SIZE_EXCEPTION = "로또는 %d개의 번호로 이뤄져야 합니다.";
    private static final String DUPLICATE_EXCEPTION = "로또에 같은 번호가 존재합니다.";
    private static final String RANGE_EXCEPTION = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_EXCEPTION, LOTTO_NUMBERS_SIZE));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
                throw new IllegalArgumentException(String.format(RANGE_EXCEPTION, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
            }
        }
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public Rank findRank(Lotto winningLotto, Bonus bonus) {
        return Rank.find(countWinningNumber(winningLotto), hasBonusNumber(bonus));
    }

    private int countWinningNumber(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    private boolean hasBonusNumber(Bonus bonus) {
        return numbers.contains(bonus.getNumber());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
