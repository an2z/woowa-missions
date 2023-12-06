package bridge.domain;

public class BridgeGameResult {

    private MoveStatus moveStatus;
    private int tryCount;

    public BridgeGameResult() {
        this.moveStatus = MoveStatus.FAIL;
        this.tryCount = 1;
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void updateMoveStatus(boolean canMove) {
        if (Boolean.TRUE.equals(canMove)) {
            moveStatus = MoveStatus.SUCCESS;
            return;
        }
        moveStatus = MoveStatus.FAIL;
    }

    public boolean isSuccess() {
        return moveStatus == MoveStatus.SUCCESS;
    }

    public boolean isFail() {
        return moveStatus == MoveStatus.FAIL;
    }

    public MoveStatus getResult() {
        return moveStatus;
    }

    public int getTryCount() {
        return tryCount;
    }
}
