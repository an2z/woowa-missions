package menu;

import java.util.List;

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
}
