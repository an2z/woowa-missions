package pairmatching.view;

import pairmatching.model.Function;

public class Output {
    private static final String FUNCTION_SELECTION = "기능을 선택하세요.";

    public void printFunctionSelection() {
        System.out.println(FUNCTION_SELECTION);
    }

    public void printFunctionList() {
        for (Function value : Function.values()) {
            System.out.println(value);
        }
    }
}
