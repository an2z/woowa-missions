package menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static final String START = "점심 메뉴 추천을 시작합니다.";
    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public static final String RESULT = "메뉴 추천 결과입니다.";
    public static final String BRACKET_OPEN = "[ ";
    public static final String BRACKET_CLOSE = " ]";
    public static final String SEPARATOR = " | ";
    public static final String DAY_TITLE = "구분";
    public static final String CATEGORY_TITLE = "카테고리";
    public static final String END = "추천을 완료했습니다.";

    public static void outputStartPhrase() {
        System.out.println(START);
    }

    public static void outputCoachNameInputPhrase() {
        System.out.println("\n" + INPUT_COACH_NAME);
    }

    public static void outputHateMenuInputPhrase(String name) {
        System.out.println("\n" + String.format(INPUT_HATE_MENU, name));
    }

    public static void outputResultPhrase() {
        System.out.println("\n" + RESULT);
    }

    public static void outputDays() {
        String result = Arrays.stream(Day.values())
                .map(Day::getValue)
                .collect(Collectors.joining(SEPARATOR));

        System.out.println(BRACKET_OPEN + DAY_TITLE + SEPARATOR + result + BRACKET_CLOSE);
    }

    public static void outputCategories(List<Category> categories) {
        String result = categories.stream()
                .map(Category::getName)
                .collect(Collectors.joining(SEPARATOR));

        System.out.println(BRACKET_OPEN + CATEGORY_TITLE + SEPARATOR + result + BRACKET_CLOSE);
    }

    public static void outputLunchMenu(LunchTeam lunchTeam) {
        List<Coach> coaches = lunchTeam.getCoaches();

        for (Coach coach : coaches) {
            String name = coach.getName();
            String lunchMenus = String.join(SEPARATOR, coach.getLunchMenus());
            System.out.println(BRACKET_OPEN + name + SEPARATOR + lunchMenus + BRACKET_CLOSE);
        }
    }

    public static void outputEndPhrase() {
        System.out.println("\n" + END);
    }

    private Output() {
    }
}
