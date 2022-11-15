package lotto.model;

import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String PREFIX = "[ERROR] ";
    private static final String SIZE_ERROR_MESSAGE = PREFIX + "로또 번호의 개수는 6개이어야 합니다.";
    private static final String DUPLICATES_ERROR_MESSAGE = PREFIX + "로또 번호에 중복된 숫자가 있습니다.";
    private static final String RANGE_ERROR_MESSAGE = PREFIX + "로또 번호에 1 ~ 45 범위를 벗어난 숫자가 있습니다.";
    private static final String DIGIT_ERROR_MESSAGE = PREFIX + "숫자만 입력 가능합니다.";
    private static final String DIGIT_COMMA_ERROR_MESSAGE = PREFIX + "숫자와 콤마(,)만 입력 가능합니다.";
    private static final String MIN_MONEY_ERROR_MESSAGE = PREFIX + "구입금액은 1000원 이상부터 가능합니다.";
    private static final String MONEY_UNIT_ERROR_MESSAGE = PREFIX + "구입금액은 1000원 단위만 가능합니다.";
    private static final String BONUS_ERROR_MESSAGE = PREFIX + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES_ERROR_MESSAGE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    public int validateNumberRange(int number) {
        if (isNotValidRange(number)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }

        return number;
    }

    public String validateDigit(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }

        return input;
    }

    public String validateDigitAndComma(String input) {
        String replacedResult = input.replaceAll("[0-9,]", "");

        if (replacedResult.length() != 0) {
            throw new IllegalArgumentException(DIGIT_COMMA_ERROR_MESSAGE);
        }

        return input;
    }

    public void validateMinMoney(int money) {
        if (money < MIN_LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERROR_MESSAGE);
        }
    }

    public void validateMoneyUnit(int money) {
        if (isNotValidMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }

    private boolean isNotValidMoneyUnit(int money) {
        return money % MIN_LOTTO_PRICE != 0;
    }

    private boolean isNotValidRange(int number) {
        return (!(MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER));
    }
}
