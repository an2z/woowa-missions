package lotto.controller;

import lotto.view.Output;

public class LottoGameController {
    private final Output output = new Output();

    public void run() {
        output.requestAmount();
    }
}
