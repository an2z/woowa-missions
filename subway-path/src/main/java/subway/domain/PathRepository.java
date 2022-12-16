package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathRepository {
    private static final String NOT_FOUND_ERROR = "[ERROR] 해당 경로를 찾을 수 없습니다.";

    private static final List<Path> paths = new ArrayList<>();

    private PathRepository() {
    }

    public static List<Path> paths() {
        return Collections.unmodifiableList(paths);
    }

    public static void addPath(Path path) {
        paths.add(path);
    }

    public static Path findPath(Station startStation, Station endStation) {
        return paths().stream()
                .filter(path -> path.getStartStation().equals(startStation) &&
                        path.getEndStation().equals(endStation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }
}
