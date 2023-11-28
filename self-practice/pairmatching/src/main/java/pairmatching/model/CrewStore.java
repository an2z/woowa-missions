package pairmatching.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewStore {
    public static final String BACKEND_CREW_DIR = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_DIR = "src/main/resources/frontend-crew.md";

    private final List<Crew> store = new ArrayList<>();

    public CrewStore() {
        addBackendCrews();
        addFrontendCrews();
    }

    private void addBackendCrews() {
        readFile(BACKEND_CREW_DIR).stream()
                .map(name -> new Crew(Course.BACKEND, name))
                .forEach(store::add);
    }

    private void addFrontendCrews() {
        readFile(FRONTEND_CREW_DIR).stream()
                .map(name -> new Crew(Course.FRONTEND, name))
                .forEach(store::add);
    }

    private List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            Path path = Paths.get(filePath);
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return lines;
    }

    public List<Crew> findAllByCourse(Course course) {
        return store.stream()
                .filter(crew -> crew.isCourse(course))
                .collect(Collectors.toList());
    }
}
