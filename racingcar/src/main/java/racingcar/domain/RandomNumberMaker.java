package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumberMaker {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public static int makeRandomNumber() {
        return pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    private RandomNumberMaker() {
    }
}
