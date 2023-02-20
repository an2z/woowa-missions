package domain;

import java.util.Random;

public class BooleanMaker {
    public static final Random random = new Random();

    public Boolean makeBoolean(Status lastStatus) {
        if (lastStatus.isConnected()) {
            return false;
        }

        return makeRandomBoolean();
    }

    private static boolean makeRandomBoolean() {
        return random.nextBoolean();
    }
}
