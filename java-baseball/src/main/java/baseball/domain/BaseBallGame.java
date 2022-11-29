package baseball.domain;

public class BaseBallGame {

    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    private Computer computer;
    private Player player;
    private Judgment judgment;
    private Command command;

    public void makePlayer(String input) {
        player = new Player(numbersGenerator.makePlayerNumbers(input));
    }

    public void makeComputer() {
        computer = new Computer(numbersGenerator.makeComputerNumbers());
    }

    public void judgeGame() {
        judgment = new Judgment();
        judgment.judge(computer, player);
    }

    public boolean isAllStrike() {
        return judgment.isAllStrike();
    }

    public boolean restarts(String input) {
        makeCommand(input);
        return command.restarts();
    }

    private void makeCommand(String input) {
        command = new Command(input);
    }

    public Judgment getJudgment() {
        return judgment;
    }
}
