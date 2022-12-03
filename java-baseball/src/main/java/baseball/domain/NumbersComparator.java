package baseball.domain;

public class NumbersComparator {

    public int compareSameNumber(Computer computer, Player player) {
        return computer.countSameNumber(player);
    }

    public int compareSamePlace(Computer computer, Player player) {
        return computer.countSamePlace(player);
    }
}
