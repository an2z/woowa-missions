package christmas.controller;

import christmas.view.OutputView;

public class EventController {
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.showGreeting();
    }
}
