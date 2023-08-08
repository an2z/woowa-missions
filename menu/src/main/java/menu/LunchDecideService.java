package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LunchDecideService {

    public static final int DAY_SIZE = 5;

    private LunchTeam lunchTeam;
    private List<Category> categories = new ArrayList<>();

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

    public void addHateMenu(String coachName, String[] hateMenu) {
        lunchTeam.addHateMenu(coachName, hateMenu);
    }

    public List<Category> decideCategory() {
        while (categories.size() < DAY_SIZE) {
            int key = Randoms.pickNumberInRange(1, 5);
            categories.add(Category.find(key));
        }

        return categories;
    }
}
