package pairmatching.controller;

import pairmatching.domain.Feature;
import pairmatching.view.Input;

public class PairMatchingController {

    private final Input input = new Input();

    public void run() {
        Feature feature = input.readFeature();
    }
}
