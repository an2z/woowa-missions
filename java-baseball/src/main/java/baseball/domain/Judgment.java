package baseball.domain;

public class Judgment {

    private final NumbersComparator comparator = new NumbersComparator();

    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        ball = comparator.compareSameNumber(computer, player);
        strike = comparator.compareSamePlace(computer, player);
        if (strike > 0) {
            ball = ball - strike;
        }
    }

    public boolean isAllStrike() {
        return strike == 3 && ball == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
