package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

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
}
