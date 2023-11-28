package pairmatching.model;

public class MatchingInfo {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public MatchingInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }
}
