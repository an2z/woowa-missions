package pairmatching.model;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private static final String COURSE_ERROR = "[ERROR] 올바르지 않은 과정입니다.";

    private final String type;
    private final String fileName;

    Course(String type, String fileName) {
        this.type = type;
        this.fileName = fileName;
    }

    public static Course getByType(String type) {
        return Arrays.stream(Course.values())
                .filter(value -> type.equals(value.type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COURSE_ERROR));
    }

    @Override
    public String toString() {
        return type;
    }
}
