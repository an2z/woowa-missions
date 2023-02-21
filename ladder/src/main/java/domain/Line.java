package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Status> points = new ArrayList<>();

    public Line(List<Boolean> randomValues) {
        for (int i = 0; i < randomValues.size(); i++) {
            points.add(makeStatus(randomValues.get(i)));
        }
    }

    private Status makeStatus(boolean randomValue) {
        if (getLastStatus().isConnected()) {
            return Status.UNCONNECTED;
        }

        return Status.find(randomValue);
    }

    private Status getLastStatus() {
        if (points.isEmpty()) {
            return Status.UNCONNECTED;
        }

        return points.get(points.size() - 1);
    }

    public List<Status> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
