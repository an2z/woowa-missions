package lotto.model;

public class LottoGame {
    private final LottoMachine lottoMachine = new LottoMachine();

    private Lottos lottos;

    public void buyLotto(int amount) {
        lottos = lottoMachine.buy(new Money(amount));
    }
}
