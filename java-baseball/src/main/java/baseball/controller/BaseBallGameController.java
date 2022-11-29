package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BaseBallGame game = new BaseBallGame();

    public void play() {
        outputView.printGameStart();
        start();
    }

    private void start() {
        game.makeComputer();
        do {
            outputView.printNumbersInputMsg();
            game.makePlayer(inputView.readPlayerNumbers());
            game.judgeGame();
            outputView.printGameResult(game.getJudgment());
        } while (!game.isAllStrike());
    }
}