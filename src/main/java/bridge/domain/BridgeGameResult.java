package bridge.domain;

public class BridgeGameResult {

    private static final String FAIL = "실패";
    private static final String SUCCESS = "성공";

    private int tryCount;
    private String result = FAIL;
    private BridgeMoveState moveState = new BridgeMoveState();

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
        result = SUCCESS;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getResult() {
        return result;
    }

    public BridgeMoveState getMoveState() {
        return moveState;
    }
}
