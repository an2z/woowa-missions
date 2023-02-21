package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, List<Boolean> randomValues) {
        for (int i = 0; i < height; i++) {
            lines.add(makeLine(randomValues));
        }
    }

    private Line makeLine(List<Boolean> randomValues) {
        return new Line(randomValues);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
