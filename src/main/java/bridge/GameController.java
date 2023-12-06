package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        inputView.readBridgeSize();
    }
}
