package pairmatching.model;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public boolean isCourse(Course course) {
        return this.course.equals(course);
    }

    public String getName() {
        return name;
    }
}
