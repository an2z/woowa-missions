package domain;

import static utils.RandomValueMaker.makeRandomValues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int width, int height) {
        for (int i = 0; i < height; i++) {
            Line line = makeLine(makeRandomValues(width));
            lines.add(line);
        }
    }

    private Line makeLine(List<Boolean> randomValues) {
        return new Line(randomValues);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
