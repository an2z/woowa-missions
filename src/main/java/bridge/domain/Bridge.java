package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> steps;

    public Bridge(List<String> steps) {
        validateSize(steps);
        this.steps = steps;
    }

    private void validateSize(List<String> steps) {
        if (steps.size() < 3 || steps.size() > 20) {
            throw new IllegalArgumentException("다리 길이는 3 이상 20 이하여야 합니다.");
        }
    }

    public boolean canMove(int index, String step) {
        return steps.get(index).equals(step);
    }

    public int getSize() {
        return steps.size();
    }
}
