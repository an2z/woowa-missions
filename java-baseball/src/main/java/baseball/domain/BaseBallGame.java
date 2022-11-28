package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    public Player makePlayer(String input) {
        return new Player(makePlayerNumbers(input));
    }

    private List<Integer> makePlayerNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (String number : input.split("")) {
            playerNumbers.add(Integer.parseInt(number));
        }
        return playerNumbers;
    }
}
