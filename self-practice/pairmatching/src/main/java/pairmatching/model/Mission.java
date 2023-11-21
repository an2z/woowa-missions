package pairmatching.model;

import java.util.Arrays;

public enum Mission {
    RACING("자동차경주"), LOTTO("로또"), BASEBALL("숫자야구게임"),
    BASKET("장바구니"), PAYMENT("결제"), SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"), DISTRIBUTION("배포");

    private static final String MISSION_ERROR = "[ERROR] 올바르지 않은 미션입니다.";

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission find(String name) {
        return Arrays.stream(Mission.values())
                .filter(value -> name.equals(value.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MISSION_ERROR));
    }

    @Override
    public String toString() {
        return name;
    }
}
