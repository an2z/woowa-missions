package baseball.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class GameController {
    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Judgement judgement = new Judgement();
    private final InputExceptionController inputExceptionController = new InputExceptionController();

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumbers = computer.createComputerNumbers();

        String judgementResult = "";

        while (!judgementResult.equals("3스트라이크")) {
            System.out.println("숫자를 입력해주세요 : ");

            String input = readLine();
            inputExceptionController.checkPlayerNumbersInputException(input);

            List<Integer> playerNumbers = player.createPlayerNumbers(input);
            judgementResult = judgement.getJudgementResult(computerNumbers, playerNumbers);

            System.out.println(judgementResult);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askRestart() {
        System.out.println("현게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = readLine();
        inputExceptionController.checkRestartInputException(input);

        return input.equals("1");
    }
}
