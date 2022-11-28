package baseball.domain;

import java.util.List;

public class NumbersComparator {

    public int compareSameNumber(List<Integer> computer, List<Integer> player) {
        return (int) player.stream()
                .filter(computer::contains)
                .count();
    }

    public int compareSamePlace(List<Integer> computer, List<Integer> player) {
        int samePlaceCount = 0;
        for (int place = 0; place < computer.size(); place++) {
            if (isSamePlace(place, computer, player)) {
                samePlaceCount++;
            }
        }
        return samePlaceCount;
    }

    private boolean isSamePlace(int place, List<Integer> computer, List<Integer> player) {
        Integer computerNumber = computer.get(place);
        Integer playerNumber = player.get(place);
        return playerNumber.equals(computerNumber);
    }
}
