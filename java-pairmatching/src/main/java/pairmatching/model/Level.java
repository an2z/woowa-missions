package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", new ArrayList<>()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", new ArrayList<>());

    private static final String LEVEL_ERROR = "[ERROR] 올바르지 않은 레벨입니다.";

    private String name;
    private List<String> missions;

    Level(String name) {
        this.name = name;
    }

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level getByName(String name) {
        return Arrays.stream(Level.values())
                .filter(value -> name.equals(value.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_ERROR));
    }
}
