package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;

public class LottoGameController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        output.requestAmount();
        input.readAmount();
    }
}
