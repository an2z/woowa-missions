package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 구한 뒤,
        Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer, player);

        // 스트라이크 개수를 구해 뺀다.
        int strike = 0;
        for (int place = 0; place < player.size(); place++) {
            if (judgement.hasPlace(computer, place, player.get(place))) {
                strike++;
            }
        }

        // 남은 개수가 볼의 개수가 된다.
        int ball = correctCount - strike;

        if (strike == 0) {
            return "아웃";
        }

        return String.format("%s 볼 %s 스트라이크", ball, strike);
    }
}
