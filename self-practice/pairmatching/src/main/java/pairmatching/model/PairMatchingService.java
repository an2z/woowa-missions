package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class PairMatchingService {
    private final CrewStore crewStore = new CrewStore();
    private final Map<MatchingInfo, List<Pair>> matchingResult = new HashMap<>();

    public List<Pair> matching(MatchingInfo matchingInfo) {
        Course course = matchingInfo.getCourse();
        List<Crew> crews = crewStore.findAllByCourse(course);
        List<Crew> shuffledCrews = Randoms.shuffle(crews);
        List<Pair> pairs = makePairs(shuffledCrews);
        matchingResult.put(matchingInfo, pairs);
        return pairs;
    }

    private List<Pair> makePairs(List<Crew> crews) {
        List<Pair> pairs = IntStream.range(0, crews.size() / 2)
                .mapToObj(i -> Pair.from(crews.get(2 * i), crews.get(2 * i + 1)))
                .toList();

        if (isOddSize(crews)) {
            Crew lastCrew = crews.get(crews.size() - 1);
            Pair lastPair = pairs.get(pairs.size() - 1);
            lastPair.addCrew(lastCrew);
        }

        return pairs;
    }

    private boolean isOddSize(List<Crew> crews) {
        return crews.size() % 2 != 0;
    }

    public Map<MatchingInfo, List<Pair>> getMatchingResult() {
        return matchingResult;
    }
}
