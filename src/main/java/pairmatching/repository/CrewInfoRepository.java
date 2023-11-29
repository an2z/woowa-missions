package pairmatching.repository;

import pairmatching.domain.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewInfoRepository {

    public static final String BACKEND_CREW_DIR = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_DIR = "src/main/resources/frontend-crew.md";

    private final List<String> backendCrewInfo;
    private final List<String> frontendCrewInfo;

    public CrewInfoRepository() {
        this.backendCrewInfo = readFile(BACKEND_CREW_DIR);
        this.frontendCrewInfo = readFile(FRONTEND_CREW_DIR);
    }

    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> findCrewInfo(Course course) {
        switch (course) {
            case BACKEND:
                return Collections.unmodifiableList(backendCrewInfo);
            case FRONTEND:
                return Collections.unmodifiableList(frontendCrewInfo);
            default:
                throw new IllegalArgumentException("해당 과정의 크루 정보는 존재하지 않습니다.");
        }
    }
}
