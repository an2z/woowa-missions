package lotto.model;

public class Bonus {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String RANGE_ERROR = "[ERROR] %d ~ %d 범위의 숫자가 아닙니다.";
    private int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(String.format(RANGE_ERROR, MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isValidRange(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }
}
