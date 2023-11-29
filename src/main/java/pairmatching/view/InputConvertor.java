package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Feature;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Mission;

public class InputConvertor {

    public static Feature convertToFeature(String input) {
        return Feature.find(input);
    }

    public static MatchInfo convertToMatchInfo(String input) {
        String[] info = input.split(", ");
        Level level = Level.find(info[1]);
        Course course = Course.find(info[0]);
        Mission mission = Mission.find(info[2], level);
        return new MatchInfo(course, level, mission);
    }

    private InputConvertor() {
    }
}
