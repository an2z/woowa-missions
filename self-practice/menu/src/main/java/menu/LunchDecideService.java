package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
        Map<Integer, Integer> map = new LinkedHashMap<>();

        while (categories.size() < DAY_SIZE) {
            int key = Randoms.pickNumberInRange(1, 5);
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) <= 2) {
                categories.add(Category.find(key));
            }
        }

        return categories;
    }

    public void decideLunch() {
        lunchTeam.decideLunch(categories);
    }
}
