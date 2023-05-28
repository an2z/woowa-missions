package pairmatching.model;

import java.util.List;
import java.util.Objects;

public class MatchingOption {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public MatchingOption(List<String> options) {
        this.course = Course.find(options.get(0));
        this.level = Level.find(options.get(1));

        if (options.size() == 3) {
            this.mission = Mission.find(options.get(2));
            return;
        }

        this.mission = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchingOption that = (MatchingOption) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
