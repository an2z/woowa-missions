package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<Shape> shapes;

    public Bridge(List<Shape> shapes) {
        validateSize(shapes);
        this.shapes = shapes;
    }

    private void validateSize(List<Shape> steps) {
        if (steps.size() < 3 || steps.size() > 20) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하여야 합니다.");
        }
    }

    public boolean canMove(int index, Shape moveShape) {
        return shapes.get(index).equals(moveShape);
    }

    public int getSize() {
        return shapes.size();
    }
}
