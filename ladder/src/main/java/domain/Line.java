package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Status> points = new ArrayList<>();

    public Line(List<Boolean> randomValues) {
        for (int i = 0; i < randomValues.size(); i++) {
            points.add(getStatus(randomValues.get(i)));
        }
    }

    public List<Status> getPoints() {
        return points;
    }

    private Status getStatus(boolean randomValue) {
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
}
