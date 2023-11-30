package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private RandomNumberMaker() {
    }
}
