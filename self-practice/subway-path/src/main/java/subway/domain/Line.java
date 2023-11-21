package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public String getName() {
        return name;
    }
}
