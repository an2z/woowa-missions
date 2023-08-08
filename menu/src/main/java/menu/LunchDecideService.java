package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LunchDecideService {

    private LunchTeam lunchTeam;

    public LunchTeam makeLunchTeam(String[] coachNames) {
        List<Coach> coaches = makeCoaches(coachNames);
        lunchTeam = new LunchTeam(coaches);
        return lunchTeam;
    }

    private List<Coach> makeCoaches(String[] coachNames) {
        return Arrays.stream(coachNames)
                .map(this::makeCoach)
                .collect(Collectors.toList());
    }

    private Coach makeCoach(String coachName) {
        return new Coach(coachName);
    }

    public List<String> findCoachNamesOfTeam() {
        return lunchTeam.findCoachNames();
    }
}
