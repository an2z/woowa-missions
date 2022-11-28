package baseball.domain;

public class BaseBallGame {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    private Computer computer;
    private Player player;

    public void makePlayer(String input) {
        player = new Player(numbersGenerator.makePlayer(input));
    }

    public void makeComputer() {
        computer = new Computer(numbersGenerator.makeComputer());
    }
}
