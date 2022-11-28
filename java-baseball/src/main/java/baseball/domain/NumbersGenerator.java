package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    public List<Integer> makeComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> makePlayer(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (String number : input.split("")) {
            playerNumbers.add(Integer.parseInt(number));
        }
        return playerNumbers;
    }
}
