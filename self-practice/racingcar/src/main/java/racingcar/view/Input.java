package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {
    private static final String DELIMITER = ",";

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return InputConvertor.convertToList(read(), DELIMITER);
    }

    private String read() {
        return Console.readLine();
    }
}
