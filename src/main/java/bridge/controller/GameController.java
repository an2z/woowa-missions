package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.RetryStatus;
import bridge.domain.Shape;
import bridge.util.RetryHandler;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

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
        BridgeGame bridgeGame = makeBridgeGame();
        while (bridgeGame.isInProgress()) {
            play(bridgeGame);
            if (bridgeGame.isFail()) {
                handleFailedGame(bridgeGame);
            }
        }
        outputView.printResult(bridgeGame.getBridgeGameMap(), bridgeGame.getGameResult(), bridgeGame.getTryCount());
    }

    private BridgeGame makeBridgeGame() {
        outputView.printStartMessage();
        Bridge bridge = RetryHandler.retry(this::makeBridge);
        return new BridgeGame(bridge);
    }

    private Bridge makeBridge() {
        int size = inputView.readBridgeSize();
        List<Shape> shapes = bridgeMaker.makeBridge(size)
                .stream()
                .map(Shape::find)
                .collect(Collectors.toList());
        return new Bridge(shapes);
    }

    private void play(BridgeGame bridgeGame) {
        Shape moveShape = RetryHandler.retry(this::makeMoveShape);
        bridgeGame.move(moveShape);
        outputView.printMap(bridgeGame.getBridgeGameMap());
    }

    private Shape makeMoveShape() {
        String moving = inputView.readMoving();
        return Shape.find(moving);
    }

    private void handleFailedGame(BridgeGame bridgeGame) {
        RetryStatus retryStatus = RetryHandler.retry(this::makeRetryStatus);
        if (retryStatus == RetryStatus.RETRY) {
            bridgeGame.retry();
        }
        if (retryStatus == RetryStatus.QUIT) {
            bridgeGame.finishGame();
        }
    }

    private RetryStatus makeRetryStatus() {
        return RetryStatus.find(inputView.readGameCommand());
    }
}
