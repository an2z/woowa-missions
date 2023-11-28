package pairmatching.model;

import java.util.List;

public class Pair {
    private final List<Crew> crews;

    private Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair from(Crew... crews) {
        return new Pair(List.of(crews));
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .toList();
    }
}
