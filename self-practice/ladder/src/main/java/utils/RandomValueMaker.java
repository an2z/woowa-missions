package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueMaker {
    public static final Random random = new Random();

    public static List<Boolean> makeRandomValues(int size) {
        List<Boolean> randomBooleans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomBooleans.add(makeRandomValue());
        }

        return randomBooleans;
    }

    private static boolean makeRandomValue() {
        return random.nextBoolean();
    }

    private RandomValueMaker() {
    }
}
