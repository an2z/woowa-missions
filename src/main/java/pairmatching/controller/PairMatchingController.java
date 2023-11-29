package pairmatching.controller;

import pairmatching.domain.Feature;
import pairmatching.domain.MatchInfo;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.function.Supplier;

public class PairMatchingController {

    private final Input input = new Input();
    private final Output output = new Output();

    public void run() {
        Feature feature = retry(input::readFeature);
        MatchInfo matchInfo = retry(input::readMatchInfo);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
