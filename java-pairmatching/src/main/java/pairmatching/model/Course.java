package pairmatching.model;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String type;

    Course(String type) {
        this.type = type;
    }
}
