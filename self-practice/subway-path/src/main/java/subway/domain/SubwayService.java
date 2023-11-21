package subway.domain;

import java.util.List;

public class SubwayService {
    private List<Station> result;

    public boolean isStart(String command) {
        return MainCommand.isLookup(command);
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

    public int calculateToTalDistance() {
        int totalDistance = 0;
        for (int index = 0; index < result.size() - 1; index++) {
            Path path = PathRepository.findPath(result.get(index), result.get(index + 1));
            totalDistance += path.getDistance();
        }
        return totalDistance;
    }

    public int calculateTotalTime() {
        int totalTime = 0;
        for (int index = 0; index < result.size() - 1; index++) {
            Path path = PathRepository.findPath(result.get(index), result.get(index + 1));
            totalTime += path.getTime();
        }
        return totalTime;
    }
}
