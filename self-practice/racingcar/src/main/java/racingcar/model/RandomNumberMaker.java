package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class RandomNumberMaker {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> makeRandomNumbers(int size) {
        return Stream.generate(RandomNumberMaker::makeRandomNumber)
                .limit(size)
                .toList();
    }

    private static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private RandomNumberMaker() {
    }
}
