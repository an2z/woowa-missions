package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int width, int height, List<Boolean> randomValues) {
        for (int i = 0; i < height; i++) {
            lines.add(makeLine(width, randomValues));
        }
    }

    private Line makeLine(int width, List<Boolean> randomValues) {
        return new Line(width, randomValues);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
