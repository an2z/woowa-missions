package pairmatching.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CrewStore {
    public static final String BACKEND_CREW_DIR = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_DIR = "src/main/resources/frontend-crew.md";

    private final Map<Course, List<String>> store = new EnumMap<>(Course.class);

    public CrewStore() {
        init();
        addBackendCrew();
        addFrontendCrew();
    }

    private void init() {
        Arrays.stream(Course.values())
                .forEach(course -> store.put(course, new ArrayList<>()));
    }

    private void addBackendCrew() {
        readFile(BACKEND_CREW_DIR)
                .forEach(name -> store.get(Course.BACKEND).add(name));
    }

    private void addFrontendCrew() {
        readFile(FRONTEND_CREW_DIR)
                .forEach(name -> store.get(Course.FRONTEND).add(name));
    }

    private List<String> readFile(String filePath) {
        List<String> lines;
        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return lines;
    }

    public List<String> findAllByCourse(Course course) {
        return store.get(course);
    }
}
