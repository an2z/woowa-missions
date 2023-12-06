package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final BridgeGameMap bridgeGameMap;

    private boolean gameResult;
    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.bridgeGameMap = new BridgeGameMap();
        this.tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String step) {
        boolean canMove = bridge.canMove(bridgeGameMap.getSize(), step);
        bridgeGameMap.addMap(step, canMove);
        gameResult = canMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeGameMap.reset();
        tryCount++;
    }

    public boolean isFail() {
        return Boolean.FALSE.equals(gameResult);
    }

    public boolean allCrossed() {
        return bridgeGameMap.getSize() == bridge.getSize();
    }

    public BridgeGameMap getBridgeGameMap() {
        return bridgeGameMap;
    }

    public boolean getGameResult() {
        return gameResult;
    }

    public int getTryCount() {
        return tryCount;
    }
}
