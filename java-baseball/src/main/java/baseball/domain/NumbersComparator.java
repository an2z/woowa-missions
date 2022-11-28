package baseball.domain;

import java.util.List;

public class NumbersComparator {

    public int compareSameNumber(List<Integer> computer, List<Integer> player) {
        return (int) player.stream()
                .filter(computer::contains)
                .count();
    }
}
