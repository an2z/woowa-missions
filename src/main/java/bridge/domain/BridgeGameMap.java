package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BridgeGameMap {

    private final List<Optional<Boolean>> upBridgeMap;
    private final List<Optional<Boolean>> downBridgeMap;

    public BridgeGameMap() {
        this.upBridgeMap = new ArrayList<>();
        this.downBridgeMap = new ArrayList<>();
    }

    public int getSize() {
        return upBridgeMap.size();
    }

    public void addMap(String step, boolean canMove) {
        if (step.equals("U")) {
            upBridgeMap.add(Optional.of(canMove));
            downBridgeMap.add(Optional.empty());
        }

        if (step.equals("D")) {
            upBridgeMap.add(Optional.empty());
            downBridgeMap.add(Optional.of(canMove));
        }
    }

    public List<Boolean> getUpBridgeMap() {
        return upBridgeMap;
    }

    public List<Boolean> getDownBridgeMap() {
        return downBridgeMap;
    }

    public List<Optional<Boolean>> getUpBridgeMap() {
        return upBridgeMap;
    }

    public List<Optional<Boolean>> getDownBridgeMap() {
        return downBridgeMap;
    }
}
