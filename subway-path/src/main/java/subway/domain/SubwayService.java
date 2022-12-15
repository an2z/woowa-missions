package subway.domain;

import java.util.List;

public class SubwayService {
    private List<Station> result;

    public boolean isStart(String command) {
        return MainCommand.find(command).isLookup();
    }

    public StandardCommand choiceStandard(String command) {
        return StandardCommand.find(command);
    }

    public List<Station> makeResultOfDistance(String startStation, String endStation) {
        result = PathGraph.getPathOfDistance(
                StationRepository.findStation(startStation), StationRepository.findStation(endStation)
        );
        return result;
    }
}
