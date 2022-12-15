package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathRepository {
    private static final List<Path> PATHS = new ArrayList<>();

    private PathRepository() {
    }

    public static List<Path> paths() {
        return Collections.unmodifiableList(PATHS);
    }

    public static void addPath(Path path) {
        PATHS.add(path);
    }
}
