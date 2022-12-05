package pairmatching.model;

import static pairmatching.model.Mission.BASEBALL;
import static pairmatching.model.Mission.BASKET;
import static pairmatching.model.Mission.DISTRIBUTION;
import static pairmatching.model.Mission.LOTTO;
import static pairmatching.model.Mission.PAYMENT;
import static pairmatching.model.Mission.PERFORMANCE;
import static pairmatching.model.Mission.RACING;
import static pairmatching.model.Mission.SUBWAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of(RACING, LOTTO, BASEBALL)),
    LEVEL2("레벨2", List.of(BASKET, PAYMENT, SUBWAY)),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", List.of(PERFORMANCE, DISTRIBUTION)),
    LEVEL5("레벨5", new ArrayList<>());

    private static final String LEVEL_ERROR = "[ERROR] 올바르지 않은 레벨입니다.";

    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level getByName(String name) {
        return Arrays.stream(Level.values())
                .filter(value -> name.equals(value.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_ERROR));
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
