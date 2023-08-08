package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Coach {

    public static final int MIN_NAME_LEN = 2;
    public static final int MAX_NAME_LEN = 4;

    private final String name;
    private final List<String> hateMenus;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.hateMenus = new ArrayList<>();
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LEN || MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자여야 합니다.");
        }
    }

    public void addHateMenu(String[] menus) {
        Collections.addAll(hateMenus, menus);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
