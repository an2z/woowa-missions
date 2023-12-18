package pairmatching.controller;

import pairmatching.domain.Feature;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.MatchOption;
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
        while (true) {
            Feature feature = retry(input::readFeature);
            if (feature == Feature.EXIT) {
                return;
            }
            performFeature(feature);
        }
    }

    private void performFeature(Feature feature) {
        MatchInfo matchInfo = retry(input::readMatchInfo);

        if (feature == Feature.PAIR_MATCHING && canMatch(matchInfo)) {
            try {
                List<Pair> pairs = service.match(matchInfo);
                output.printPairMatchingResult(pairs);
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }

        if (feature == Feature.PAIR_LOOKUP) {
            List<Pair> pairs = service.lookUp(matchInfo);
            output.printPairMatchingResult(pairs);
        }

        if (feature == Feature.PAIR_RESET) {
            service.reset();
        }
    }

    private boolean canMatch(MatchInfo matchInfo) {
        if (service.hasMatchingResult(matchInfo)) {
            MatchOption matchOption = retry(input::readMatchOption);
            return matchOption == MatchOption.YES;
        }
        return true;
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
