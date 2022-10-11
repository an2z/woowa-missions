package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> computer = numberGenerator.createRandomNumbers();

        Referee referee = new Referee();

        String result = "";

        while (!result.equals("0 볼 3 스트라이크")) {
            result = referee.compare(computer, askPlayer());
            System.out.println(result);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> askPlayer() {
        System.out.print("숫자를 입력해 주세요 : ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<Integer> player = new ArrayList<>();
        for (String number : input.split("")) {
            player.add(Integer.valueOf(number));
        }

        return player;
    }
}
