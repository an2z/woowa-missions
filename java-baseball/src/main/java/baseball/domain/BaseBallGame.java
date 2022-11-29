package baseball.domain;

public class BaseBallGame {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    private Computer computer;
    private Player player;
    private Judgment judgment;

    public void makePlayer(String input) {
        player = new Player(numbersGenerator.makePlayer(input));
    }

    public void makeComputer() {
        computer = new Computer(numbersGenerator.makeComputer());
    }

    public void judgeGame() {
        judgment = new Judgment();
        judgment.judge(computer, player);
    }

    public boolean isAllStrike() {
        return judgment.isAllStrike();
    }

    public Judgment getJudgment() {
        return judgment;
    }
}
