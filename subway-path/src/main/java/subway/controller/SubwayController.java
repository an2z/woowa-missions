package subway.controller;

import java.util.Scanner;
import subway.domain.SubwayService;
import subway.veiw.Input;
import subway.veiw.Output;

public class SubwayController {
    public final Input input;
    public final Output output;
    public final SubwayService subwayService;

    public SubwayController(Scanner scanner) {
        input = new Input(scanner);
        output = new Output();
        subwayService = new SubwayService();
    }

    public void run() {
        output.printMain();
        output.askChoice();
        if (isStart()) {
            // 경로 조회 구현
        }
    }

    private boolean isStart() {
        try {
            return subwayService.isStart(input.read());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return isStart();
        }
    }
}
