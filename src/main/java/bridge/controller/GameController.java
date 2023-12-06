package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.RetryStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }


    public void run() {
        outputView.printStartMessage();
        Bridge bridge = retry(this::makeBridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        boolean flag = true;
        while (flag) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeGameMap());

            if (bridgeGame.isFail()) {
                RetryStatus retryStatus = RetryStatus.find(inputView.readGameCommand());
                if (retryStatus.equals(RetryStatus.RETRY)) {
                    bridgeGame.retry();
                }
                if (retryStatus.equals(RetryStatus.QUIT)) {
                    flag = false;
                }
            }
            if (bridgeGame.allCrossed()) {
                flag = false;
            }
        }

        outputView.printResult(bridgeGame.getBridgeGameMap(), bridgeGame.getGameResult(), bridgeGame.getTryCount());
    }

    private Bridge makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> steps = bridgeMaker.makeBridge(size);
        return new Bridge(steps);
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
