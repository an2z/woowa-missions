package pairmatching.view;

import pairmatching.domain.Feature;

public class InputConvertor {

    public static Feature convert(String input) {
        return Feature.find(input);
    }

    private InputConvertor() {
    }
}
