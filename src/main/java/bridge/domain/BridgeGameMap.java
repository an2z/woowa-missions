package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameMap {

    private final List<Boolean> upBridgeMap;
    private final List<Boolean> downBridgeMap;

    public BridgeGameMap() {
        this.upBridgeMap = new ArrayList<>();
        this.downBridgeMap = new ArrayList<>();
    }

    public int getSize() {
        return upBridgeMap.size();
    }

    public void addMap(String step, boolean canMove) {
        if (step.equals("U")) {
            upBridgeMap.add(canMove);
            downBridgeMap.add(null);
        }

        if (step.equals("D")) {
            downBridgeMap.add(canMove);
            upBridgeMap.add(null);
        }
    }

    public List<Boolean> getUpBridgeMap() {
        return upBridgeMap;
    }

    public List<Boolean> getDownBridgeMap() {
        return downBridgeMap;
    }
}
