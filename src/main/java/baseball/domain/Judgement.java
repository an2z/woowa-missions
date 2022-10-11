package baseball.domain;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int count = 0;

        for (int i = 0; i < player.size(); i++) {
            int playerNumber = player.get(i);
            if (computer.contains(playerNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasPlace(int place, int number) {
        return false;
    }
}
