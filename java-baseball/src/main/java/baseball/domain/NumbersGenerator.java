package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBERS_SIZE = 3;

    public List<Integer> makeComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> makePlayerNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (String number : input.split("")) {
            playerNumbers.add(Integer.parseInt(number));
        }
        return playerNumbers;
    }
}
