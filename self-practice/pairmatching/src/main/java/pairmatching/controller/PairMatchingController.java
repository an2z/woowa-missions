package pairmatching.controller;

import pairmatching.model.Course;
import pairmatching.model.Function;
import pairmatching.model.Level;
import pairmatching.model.MatchingInfo;
import pairmatching.model.Mission;
import pairmatching.model.Pair;
import pairmatching.model.PairMatchingService;
import pairmatching.model.RematchDecision;
import pairmatching.view.Input;
import pairmatching.view.Output;

import java.util.List;
import java.util.function.Supplier;

public class PairMatchingController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final PairMatchingService pairMatchingService = new PairMatchingService();

    public void run() {
        while (true) {
            Function function = retry(() -> Function.of(input.readFunction()));
            if (function.isExit()) {
                return;
            }
            progress(function);
        }
    }

    private void progress(Function function) {
        MatchingInfo matchingInfo = retry(() -> makeMatchingInfo(input.readMatchingInfo()));

        if (function.equals(Function.MATCHING) && canMatching(matchingInfo)) {
            List<Pair> pairs = pairMatchingService.matching(matchingInfo);
            output.printMatchingResult(pairs);
        }
    }

    private boolean canMatching(MatchingInfo matchingInfo) {
        if (pairMatchingService.isExist(matchingInfo)) {
            RematchDecision rematchDecision = retry(() -> RematchDecision.find(input.readReMathDecision()));
            return rematchDecision.equals(RematchDecision.YES);
        }
        return true;
    }

    private MatchingInfo makeMatchingInfo(List<String> infos) {
        Course course = Course.find(infos.get(0));
        Level level = Level.find(infos.get(1));
        Mission mission = Mission.find(infos.get(2), level);
        return new MatchingInfo(course, level, mission);
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
