package pairmatching.controller;

import pairmatching.domain.Feature;
import pairmatching.domain.MatchInfo;
import pairmatching.service.PairMatchingService;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.function.Supplier;

public class PairMatchingController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final PairMatchingService service = new PairMatchingService();

    public void run() {
        Feature feature = retry(input::readFeature);
        performFeature(feature);
    }

    private void performFeature(Feature feature) {
        MatchInfo matchInfo = retry(input::readMatchInfo);

        if (feature == Feature.PAIR_MATCHING) {
            service.pairMatching(matchInfo);
        }
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
