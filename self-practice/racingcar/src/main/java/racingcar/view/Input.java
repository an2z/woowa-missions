package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return InputConvertor.convertToList(read(), DELIMITER);
    }

    public int readNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return InputConvertor.convertToInt(read());
    }

    private String read() {
        return Console.readLine();
    }
}
