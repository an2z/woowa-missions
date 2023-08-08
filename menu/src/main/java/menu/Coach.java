package menu;

import java.util.ArrayList;
import java.util.List;

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

    public String getName() {
        return name;
    }
}
