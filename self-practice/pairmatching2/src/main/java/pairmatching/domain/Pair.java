package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pair {

    private final List<Crew> crews;

    private Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair of(Crew... crew) {
        return new Pair(Arrays.asList(crew));
    }

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public boolean hasCrew(Crew crew) {
        return this.crews.contains(crew);
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        // 최소한 두 개의 크루가 공통으로 포함되어 있다면 두 Pair 객체를 같다고 간주
        long commonCrewCount = this.crews.stream()
                .filter(pair::hasCrew)
                .count();
        return commonCrewCount >= 2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crews);
    }
}
