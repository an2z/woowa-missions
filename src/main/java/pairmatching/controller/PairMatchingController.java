package pairmatching.controller;

import pairmatching.domain.Feature;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.service.PairMatchingService;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.List;
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
            List<Pair> pairs = service.match(matchInfo);
            output.printPairMatchingResult(pairs);
        }

        if (feature == Feature.PAIR_LOOKUP) {
            List<Pair> pairs = service.lookUp(matchInfo);
            output.printPairMatchingResult(pairs);
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
