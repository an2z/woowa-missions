package lotto.model;

public class WinningLotto {
    private static final String DUPLICATION_ERROR = "[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.";

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (bonus.isExist(lotto)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }
}
