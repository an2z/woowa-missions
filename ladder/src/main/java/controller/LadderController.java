package controller;

import domain.LadderService;
import view.Input;
import view.Output;

public class LadderController {
    private final LadderService ladderService;

    public LadderController() {
        this.ladderService = new LadderService();
    }

    public void run() {
        Output.printStartMessage();
        ladderService.makePlayers(Input.readNames());

        Output.printLadderHeightMessage();
        ladderService.makeHeight(Input.readLadderHeight());
    }
}
