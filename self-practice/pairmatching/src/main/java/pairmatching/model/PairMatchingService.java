package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PairMatchingService {
    private final CrewStore crewStore = new CrewStore();
    private final Map<MatchingInfo, List<Pair>> matchingResult = new HashMap<>();

    public boolean isExist(MatchingInfo matchingInfo) {
        return matchingResult.containsKey(matchingInfo);
    }

    public List<Pair> matching(MatchingInfo matchingInfo) {
        Course course = matchingInfo.getCourse();

        List<String> crewNames = crewStore.findAllByCourse(course);
        List<String> shuffledCrewNames = Randoms.shuffle(crewNames);

        List<Crew> crews = makeCrews(course, shuffledCrewNames);
        List<Pair> pairs = makePairs(crews);

        matchingResult.put(matchingInfo, pairs);
        return pairs;
    }

    private List<Crew> makeCrews(Course course, List<String> names) {
        return names.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }

    private List<Pair> makePairs(List<Crew> crews) {
        List<Pair> pairs = IntStream.range(0, crews.size() / 2)
                .mapToObj(i -> Pair.from(crews.get(2 * i), crews.get(2 * i + 1)))
                .collect(Collectors.toList());

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

    public List<Pair> findMatchingResult(MatchingInfo matchingInfo) {
        if (matchingResult.containsKey(matchingInfo)) {
            return matchingResult.get(matchingInfo);
        }
        throw new IllegalArgumentException("매칭 이력이 없습니다.");
    }

    public Map<MatchingInfo, List<Pair>> getMatchingResult() {
        return matchingResult;
    }
}
