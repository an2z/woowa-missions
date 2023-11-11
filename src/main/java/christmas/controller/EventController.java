package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.showGreeting();
        inputView.readDate();
    }
}
