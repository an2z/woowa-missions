package pairmatching.domain;

import static pairmatching.domain.Level.LEVEL1;
import static pairmatching.domain.Level.LEVEL2;
import static pairmatching.domain.Level.LEVEL4;

public enum Mission {
    RACING_CAR(LEVEL1, "자동차경주"),
    LOTTO(LEVEL1, "로또"),
    NUMBER_BASEBALL(LEVEL1, "숫자야구게임"),
    SHOPPING_CART(LEVEL2, "장바구니"),
    PAYMENT(LEVEL2, "결제"),
    SUBWAY_MAP(LEVEL2, "지하철노선도"),
    PERFORMANCE_IMPROVEMENT(LEVEL4, "성능개선"),
    DEPLOYMENT(LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }
}
