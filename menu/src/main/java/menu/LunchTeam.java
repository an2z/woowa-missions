package menu;

import java.util.List;
import java.util.stream.Collectors;

public class LunchTeam {

    private final List<Coach> coaches;

    public LunchTeam(List<Coach> coaches) {
        validateSize(coaches);
        this.coaches = coaches;
    }

    private void validateSize(List<Coach> coaches) {
        if (coaches.size() < 2 || 5 < coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치는 2~5명으로 구성되어야 합니다.");
        }
    }

    public List<String> findCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public void addHateMenu(String coachName, String[] hateMenu) {
        findCoach(coachName).addHateMenu(hateMenu);
    }

    private Coach findCoach(String coachName) {
        return coaches.stream()
                .filter(coach -> coach.equals(new Coach(coachName)))
                .findFirst()
                .orElseThrow();
    }
}
