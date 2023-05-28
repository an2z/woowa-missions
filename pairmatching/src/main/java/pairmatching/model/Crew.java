package pairmatching.model;

import java.util.List;
import java.util.Objects;

public class Crew {
    private final Course course;
    private final List<String> names;

    public Crew(Course course, List<String> names) {
        this.course = course;
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(names, crew.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, names);
    }
}
