package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> crews;

    private Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair from(Crew... crews) {
        return new Pair(Arrays.asList(crews));
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
