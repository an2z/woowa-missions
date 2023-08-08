package menu;

public class Output {

    public static final String START = "점심 메뉴 추천을 시작합니다.";
    public static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static void outputStartPhrase() {
        System.out.println(START);
    }

    public static void outputCoachNameInputPhrase() {
        System.out.println("\n" + INPUT_COACH_NAME);
    }

    private Output() {
    }
}
