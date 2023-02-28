package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Status> statuses = new ArrayList<>();

    public Line(List<Boolean> randomValues) {
        for (int i = 0; i < randomValues.size(); i++) {
            statuses.add(makeStatus(randomValues.get(i)));
        }
    }

    private Status makeStatus(boolean randomValue) {
        if (getLastStatus().isConnected()) {
            return Status.UNCONNECTED;
        }

        return Status.find(randomValue);
    }

    private Status getLastStatus() {
        if (statuses.isEmpty()) {
            return Status.UNCONNECTED;
        }

        return statuses.get(statuses.size() - 1);
    }

    public List<Status> getStatuses() {
        return Collections.unmodifiableList(statuses);
    }
}
