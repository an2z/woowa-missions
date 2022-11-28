package baseball.domain;

import java.util.List;

public class BaseBallGame {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    private Computer computer;
    private Player player;

    public Player makePlayer(String input) {
        List<Integer> playerNumbers = numbersGenerator.makePlayer(input);
        player = new Player(playerNumbers);
        return player;
    }

    public void makeComputer() {
        computer = new Computer(numbersGenerator.makeComputer());
    }
}
