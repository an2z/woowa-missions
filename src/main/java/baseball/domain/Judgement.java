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

    public boolean hasPlace(List<Integer> computer, int place, int number) {
        //        if (computer.get(place) == number) {
        //            return true;
        //        }
        //        return false;

        return computer.get(place) == number;
    }
}
