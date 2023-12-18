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

    public void addMap(Shape shape, boolean canMove) {
        if (shape == Shape.UP) {
            upBridgeMap.add(Optional.of(canMove));
            downBridgeMap.add(Optional.empty());
        }
        if (shape == Shape.DOWN) {
            upBridgeMap.add(Optional.empty());
            downBridgeMap.add(Optional.of(canMove));
        }
    }

    public void reset() {
        upBridgeMap.clear();
        downBridgeMap.clear();
    }

    public List<Optional<Boolean>> getUpBridgeMap() {
        return upBridgeMap;
    }

    public List<Optional<Boolean>> getDownBridgeMap() {
        return downBridgeMap;
    }
}
