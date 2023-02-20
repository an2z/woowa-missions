package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Status> points = new ArrayList<>();
    private final BooleanMaker booleanMaker = new BooleanMaker();

    public Line(int playerCount) {
        for (int i = 1; i < playerCount; i++) {
            points.add(getStatus());
        }
    }

    private Status getStatus() {
        return Status.find(booleanMaker.makeBoolean(getLastStatus()));
    }

    private Status getLastStatus() {
        if (points.isEmpty()) {
            return Status.UNCONNECTED;
        }

        return points.get(points.size() - 1);
    }
}
