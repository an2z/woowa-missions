package baseball.view;

import baseball.domain.Judgment;

public class OutputView {

    private static final String BLANK = " ";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String PLAYER_NUMBERS_INPUT = "숫자를 입력해주세요 : ";
    private static final String GAME_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_COMMAND_INPUT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printNumbersInputMsg() {
        System.out.print(PLAYER_NUMBERS_INPUT);
    }

    public void printGameSuccess() {
        System.out.println(GAME_SUCCESS);
    }

    public void printGameCommandInputMsg() {
        System.out.println(GAME_COMMAND_INPUT);
    }

    public void printGameResult(Judgment judgment) {
        int ball = judgment.getBall();
        int strike = judgment.getStrike();
        System.out.println(makeGameResult(ball, strike));
    }

    private String makeGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NOTHING;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        if (strike == 0) {
            return ball + BALL;
        }
        return ball + BALL + BLANK + strike + STRIKE;
    }
}
