package subway.domain;

import java.util.List;

public class SubwayService {
    public boolean isStart(String command) {
        return MainCommand.find(command).isLookup();
    }

    public StandardCommand choiceStandard(String command) {
        return StandardCommand.find(command);
    }

    public List<Station> findPathOfDistance(String startStation, String endStation) {
        return PathGraph.getPathOfDistance(
                StationRepository.findStation(startStation), StationRepository.findStation(endStation)
        );
    }
}
