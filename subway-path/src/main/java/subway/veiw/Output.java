package subway.veiw;

public class Output {
    private static final String MAIN = "## 메인 화면%n1. 경로 조회%nQ. 종료%n";
    private static final String CHOICE = "%n## 원하는 기능을 선택하세요.%n";

    public void printMain() {
        System.out.printf(MAIN);
    }

    public void askChoice() {
        System.out.printf(CHOICE);
    }
}
