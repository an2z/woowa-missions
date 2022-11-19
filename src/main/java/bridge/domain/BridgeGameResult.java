package bridge.domain;

/**
 * 다리 건너기 게임의 최종 결과를 관리하는 클래스
 */
public class BridgeGameResult {

    private static final int FIRST_COUNT = 1;
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private int tryCount;
    private String gameResult;
    private BridgeMoveState moveState;

    public BridgeGameResult() {
        tryCount = FIRST_COUNT;
        gameResult = FAIL;
        moveState = new BridgeMoveState();
    }

    public int increaseTryCount() {
        return ++tryCount;
    }

    public void initMoveState() {
        moveState = new BridgeMoveState();
    }

    public void updateMoveState(String moving, Boolean canMove) {
        moveState.update(moving, canMove);
    }

    public void setSuccess() {
        gameResult = SUCCESS;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getGameResult() {
        return gameResult;
    }

    public BridgeMoveState getMoveState() {
        return moveState;
    }
}
