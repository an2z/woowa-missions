package view;

public class Output {
    private static final String START = "참여할 사람 이름을 입력하세요. (이름을 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";

    public static void printStartMessage() {
        System.out.println(START);
    }

    public static void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT);
    }

    private Output() {
    }
}
