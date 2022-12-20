package lotto.controller;

import java.util.List;
import lotto.model.LottoGame;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGameController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoGame game = new LottoGame();

    public void run() {
        output.requestAmount();
        game.buyLotto(input.readAmount());
        output.printLotto(game.getLottos());

        output.requestWinningNumbers();
        List<Integer> winningNumbers = input.readWinningNumbers();
        output.requestBonusNumber();
        int bonusNumber = input.readBonusNumber();
        game.makeWinningLotto(winningNumbers, bonusNumber);
    }
}
