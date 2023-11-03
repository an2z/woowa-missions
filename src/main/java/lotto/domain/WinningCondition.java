package lotto.domain;

public class WinningCondition {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningCondition(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }
}
