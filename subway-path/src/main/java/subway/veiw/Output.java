package subway.veiw;

public class Output {
    private static final String MAIN = "## 메인 화면%n1. 경로 조회%nQ. 종료%n";
    private static final String CHOICE = "%n## 원하는 기능을 선택하세요.%n";
    private static final String STANDARD = "%n## 경로 기준%n1. 최단 거리%n2. 최단시간%nB. 돌아가기%n";
    private static final String START_STATION = "%n## 출발역을 입력하세요.%n";
    private static final String END_STATION = "%n## 도착역을 입력하세요.%n";
    private static final String ERROR = "[ERROR] ";

    public void printMain() {
        System.out.printf(MAIN);
    }

    public void askChoice() {
        System.out.printf(CHOICE);
    }

    public void printStandard() {
        System.out.printf(STANDARD);
    }

    public void askStartStation() {
        System.out.printf(START_STATION);
    }

    public void askEndStation() {
        System.out.printf(END_STATION);
    }

    public void printError(String massage) {
        System.out.println(ERROR + massage);
    }
}
