package subway.controller;

import java.util.Scanner;
import subway.domain.StandardCommand;
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
            lookup();
        }
    }

    private void lookup() {
        output.printStandard();

        if (choiceStandard().isDistance()) {
            output.askStartStation();
            String startStation = input.read();
            output.askEndStation();
            String endStation = input.read();

            output.printResult(
                    subwayService.makeResultOfDistance(startStation, endStation)
            );
        }
    }

    private StandardCommand choiceStandard() {
        try {
            return subwayService.choiceStandard(input.read());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return choiceStandard();
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
