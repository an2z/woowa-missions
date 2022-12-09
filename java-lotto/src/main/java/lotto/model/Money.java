package lotto.model;

import java.util.Objects;

public class Money {
    private static final int MIN_MONEY = 1000;
    private static final String MONEY_ERROR = "[ERROR] %d원 단위만 가능합니다.";

    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public void validate(int amount) {
        if (isWrongUnit(amount) || isSmallerThanMin(amount)) {
            throw new IllegalArgumentException(String.format(MONEY_ERROR, MIN_MONEY));
        }
    }

    private static boolean isSmallerThanMin(int amount) {
        return amount < MIN_MONEY;
    }

    private static boolean isWrongUnit(int amount) {
        return amount % MIN_MONEY != 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
