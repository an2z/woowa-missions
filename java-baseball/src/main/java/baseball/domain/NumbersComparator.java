package baseball.domain;

import java.util.List;

public class NumbersComparator {

    public int compareSameNumber(List<Integer> computer, List<Integer> player) {
        int sameNumberCount = 0;
        for (Integer playerNumber : player) {
            if (computer.contains(playerNumber)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }
}
