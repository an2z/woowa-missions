package pairmatching.controller;

import pairmatching.model.Function;
import pairmatching.view.Input;

import java.util.function.Supplier;

public class PairMatchingController {
    private final Input input = new Input();

    public void run() {
        Function function = retry(() -> Function.of(input.readFunction()));
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                //todo: 에러 메시지 출력 기능 구현
                //output.printError(e.getMessage());
            }
        }
    }
}
