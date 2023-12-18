package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewInfoRepository;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairMatchingService {

    private final CrewInfoRepository crewInfoRepository;

    private Map<MatchInfo, List<Pair>> pairMatchingResults;
    private Map<Level, List<Pair>> pairHistoryByLevel;

    public PairMatchingService() {
        crewInfoRepository = new CrewInfoRepository();
        pairMatchingResults = new HashMap<>();
        pairHistoryByLevel = new EnumMap<>(Level.class);
    }

    public List<Pair> match(MatchInfo matchInfo) {
        Course course = matchInfo.getCourse();
        Level level = matchInfo.getLevel();
        List<String> crewInfo = crewInfoRepository.findCrewInfo(course);

        for (int i = 0; i < 3; i++) {
            List<Crew> crews = makeShuffledCrews(course, crewInfo);
            List<Pair> pairs = makePairs(crews);

            if (canMatching(level, pairs)) {
                pairs.forEach(pair -> {
                    pairMatchingResults.computeIfAbsent(matchInfo, key -> new ArrayList<>()).add(pair);
                    pairHistoryByLevel.computeIfAbsent(level, key -> new ArrayList<>()).add(pair);
                });
                return pairs;
            }
        }

        throw new IllegalArgumentException("매칭에 실패했습니다.");
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
        for (int i = 0; i < crews.size(); i += 2) {
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

    private boolean canMatching(Level level, List<Pair> pairs) {
        if (pairHistoryByLevel.containsKey(level)) {
            List<Pair> pairHistory = this.pairHistoryByLevel.get(level);
            return pairs.stream()
                    .noneMatch(pairHistory::contains);
        }
        return true;
    }

    public List<Pair> lookUp(MatchInfo matchInfo) {
        if (pairMatchingResults.containsKey(matchInfo)) {
            return pairMatchingResults.get(matchInfo);
        }
        throw new IllegalArgumentException("매칭 이력이 없습니다.");
    }

    public boolean hasMatchingResult(MatchInfo matchInfo) {
        return pairMatchingResults.containsKey(matchInfo);
    }

    public void reset() {
        pairMatchingResults = new HashMap<>();
        pairHistoryByLevel = new EnumMap<>(Level.class);
    }
}
