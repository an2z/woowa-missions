package baseball.domain;

import java.util.List;

public class BaseBallGame {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    private Player player;

    public Player makePlayer(String input) {
        List<Integer> playerNumbers = numbersGenerator.makePlayer(input);
        player = new Player(playerNumbers);
        return player;
    }
}
