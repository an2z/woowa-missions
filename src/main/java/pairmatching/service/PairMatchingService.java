package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.MatchInfo;
import pairmatching.repository.CrewInfoRepository;

import java.util.List;

public class PairMatchingService {

    private final CrewInfoRepository crewInfoRepository;

    public PairMatchingService(CrewInfoRepository crewInfoRepository) {
        this.crewInfoRepository = crewInfoRepository;
    }

    public void pairMatching(MatchInfo matchInfo) {
        List<String> crewInfo = crewInfoRepository.findCrewInfo(matchInfo.getCourse());
        List<String> shuffledCrewInfo = Randoms.shuffle(crewInfo);
    }
}
