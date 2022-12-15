package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayRepository {
    private static final Map<Line, List<Station>> subways = new HashMap<>();

    public static Map<Line, List<Station>> subways() {
        return Collections.unmodifiableMap(subways);
    }

    public static void addSubway(Line line, List<Station> stations) {
        subways.put(line, stations);
    }
}
