package christmas.domain;

import java.util.Arrays;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int condition;

    EventBadge(String name, int condition) {
        this.name = name;
        this.condition = condition;
    }

    public static EventBadge find(int totalBenefit) {
        return Arrays.stream(values())
                .filter(eventBadge -> eventBadge.condition <= totalBenefit)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
