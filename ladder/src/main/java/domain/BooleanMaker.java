package domain;

import static java.lang.Boolean.TRUE;

import java.util.Random;

public class BooleanMaker {
    public static final Random random = new Random();

    public Boolean makeBoolean(Boolean lastStatus) {
        if (TRUE.equals(lastStatus)) {
            return false;
        }

        return makeRandomBoolean();
    }

    private static boolean makeRandomBoolean() {
        return random.nextBoolean();
    }
}
