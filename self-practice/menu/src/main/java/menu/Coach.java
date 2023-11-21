package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Coach {

    public static final int MIN_NAME_LEN = 2;
    public static final int MAX_NAME_LEN = 4;
    public static final int MAX_HATE_MENU_SIZE = 2;

    private final String name;
    private final List<String> hateMenus;
    private final List<String> lunchMenus;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.hateMenus = new ArrayList<>();
        this.lunchMenus = new ArrayList<>();
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LEN || MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자여야 합니다.");
        }
    }

    public void addHateMenu(String[] menus) {
        validateHateMenuSize(menus);
        Collections.addAll(hateMenus, menus);
    }

    private void validateHateMenuSize(String[] menus) {
        if (MAX_HATE_MENU_SIZE < menus.length) {
            throw new IllegalArgumentException("[ERROR] 싫어하는 메뉴의 개수는 0~2개여야 합니다.");
        }
    }

    public void addLunchMenu(List<Category> categories) {
        for (Category category : categories) {
            lunchMenus.add(pickUniqueAndLikeMenu(category));
        }
    }

    private String pickUniqueAndLikeMenu(Category category) {
        String menu;
        do {
            menu = category.pickMenu();
        } while (isHateMenu(menu) && isNotUniqueMenu(menu));

        return menu;
    }

    private boolean isHateMenu(String menu) {
        return hateMenus.contains(menu);
    }

    private boolean isNotUniqueMenu(String menu) {
        return lunchMenus.contains(menu);
    }

    public String getName() {
        return name;
    }

    public List<String> getLunchMenus() {
        return lunchMenus;
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
