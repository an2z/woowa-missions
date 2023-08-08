package menu;

public class Output {

    public static final String START = "점심 메뉴 추천을 시작합니다.";
    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_HATE_MENU = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static void outputStartPhrase() {
        System.out.println(START);
    }

    public static void outputCoachNameInputPhrase() {
        System.out.println("\n" + INPUT_COACH_NAME);
    }

    public static void outputHateMenuInputPhrase(String name) {
        System.out.println("\n" + String.format(INPUT_HATE_MENU, name));
    }

    private Output() {
    }
}
