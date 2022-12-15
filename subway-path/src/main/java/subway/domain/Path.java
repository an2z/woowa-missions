package subway.domain;

public class Path {
    private Station startStation;
    private Station endStation;
    private int distance;
    private int time;

    public Path(Station startStation, Station endStation, int distance, int time) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
        this.time = time;
    }
}
