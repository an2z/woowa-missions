package pairmatching.model;

import static pairmatching.model.Level.LEVEL1;
import static pairmatching.model.Level.LEVEL2;
import static pairmatching.model.Level.LEVEL4;

public enum Mission {
    RACING_CAR("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", LEVEL1),
    SHOPPING_CART("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY_MAP("지하철노선도", LEVEL2),
    PERFORMANCE_IMPROVEMENT("성능개선", LEVEL4),
    DEPLOYMENT("배포", LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }
}
