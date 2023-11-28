package pairmatching.view;

import pairmatching.model.Function;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public String readFunction() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(Function.values()).forEach(System.out::println);
        return read();
    }

    private String read() {
        return readLine();
    }
}
