package baseball.domain;

public class Judgment {
    private final NumbersComparator comparator = new NumbersComparator();

    private int ball;
    private int strike;

    public void judge(Computer computer, Player player) {
        ball = comparator.compareSameNumber(computer, player);
        int samePlaceCount = comparator.compareSamePlace(computer, player);
        if (samePlaceCount > 0) {
            strike = samePlaceCount;
            ball = ball - strike;
        }
    }
}
