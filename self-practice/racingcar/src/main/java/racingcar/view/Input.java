package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = InputValidator.validateCarNamesFormat(read());
        return InputConvertor.convertToList(input, DELIMITER);
    }

    public int readNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = InputValidator.validateNumber(read());
        return InputConvertor.convertToInt(input);
    }

    private String read() {
        String input = Console.readLine();
        return InputValidator.validateBlank(input);
    }
}
