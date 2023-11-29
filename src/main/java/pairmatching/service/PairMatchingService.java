package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewInfoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairMatchingService {

    private final CrewInfoRepository crewInfoRepository;
    private final Map<MatchInfo, List<Pair>> pairMatchingResults;

    public PairMatchingService() {
        crewInfoRepository = new CrewInfoRepository();
        pairMatchingResults = new HashMap<>();
    }

    public List<Pair> match(MatchInfo matchInfo) {
        Course course = matchInfo.getCourse();
        List<String> crewInfo = crewInfoRepository.findCrewInfo(course);
        List<Crew> crews = makeShuffledCrews(course, crewInfo);
        List<Pair> pairs = makePairs(crews);
        pairMatchingResults.put(matchInfo, pairs);
        return pairs;
    }

    private List<Crew> makeShuffledCrews(Course course, List<String> crewInfo) {
        return Randoms.shuffle(crewInfo)
                .stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }

    private List<Pair> makePairs(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();

        // 앞에서부터 순서대로 두명씩 페어 생성
        for (int i = 0; i < crews.size() / 2; i += 2) {
            pairs.add(Pair.of(crews.get(i), crews.get(i + 1)));
        }
        // 홀수 크루일 경우 마지막 페어에 추가
        if (crews.size() % 2 != 0) {
            Pair lastPair = pairs.get(pairs.size() - 1);
            Crew lastCrew = crews.get(crews.size() - 1);
            lastPair.addCrew(lastCrew);
        }

        return pairs;
    }
}
