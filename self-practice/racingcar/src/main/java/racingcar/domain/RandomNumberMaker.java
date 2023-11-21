package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberMaker {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public static List<Integer> makeRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(makeRandomNumber());
        }

        return numbers;
    }

    private static int makeRandomNumber() {
        return pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    private RandomNumberMaker() {
    }
}
