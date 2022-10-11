package baseball;

import baseball.domain.Referee;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee();

        String result1 = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        System.out.println("result1 = " + result1); // 0볼 3 스트라이크

        String result2 = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 3));
        System.out.println("result2 = " + result2); // 2 볼 1 스트라이크

        String result3 = referee.compare(Arrays.asList(4, 5, 7), Arrays.asList(2, 1, 3));
        System.out.println("result3 = " + result3); // 아웃
    }
}
