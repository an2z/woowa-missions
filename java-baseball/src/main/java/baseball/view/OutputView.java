package baseball.view;

import baseball.domain.Judgment;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printNumbersInputMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameSuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameCommandInputMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printGameResult(Judgment judgment) {
        int ball = judgment.getBall();
        int strike = judgment.getStrike();
        System.out.println(makeGameResult(ball, strike));
    }

    private String makeGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (strike == 3) {
            return strike + "스트라이크";
        }
        if (ball == 3) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
