package view;

public class Output {
    private static final String START = "참여할 사람 이름을 입력하세요. (이름을 쉼표(,)로 구분하세요)";

    public static void printStartMessage() {
        System.out.println(START);
    }

    private Output() {
    }
}
