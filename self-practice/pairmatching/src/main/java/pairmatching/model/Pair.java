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
}
