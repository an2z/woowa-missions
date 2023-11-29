package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {

    private List<Crew> crews;

    private Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair of(Crew crew1, Crew crew2) {
        return new Pair(Arrays.asList(crew1, crew2));
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
