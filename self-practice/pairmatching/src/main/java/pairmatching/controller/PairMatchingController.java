package pairmatching.controller;

import pairmatching.model.Function;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.function.Supplier;

public class PairMatchingController {
    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        Function function = retry(() -> Function.of(input.readFunction()));
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
