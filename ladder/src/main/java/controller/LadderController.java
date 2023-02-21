package controller;

import domain.Ladder;
import domain.LadderService;
import domain.Players;
import view.Input;
import view.Output;

public class LadderController {
    private final LadderService ladderService;

    public LadderController() {
        this.ladderService = new LadderService();
    }

    public void run() {
        Output.printStartMessage();
        Players players = ladderService.makePlayers(Input.readNames());

        Output.printLadderHeightMessage();
        ladderService.makeHeight(Input.readLadderHeight());

        Ladder ladder = ladderService.makeLadder();
        Output.printResult(players, ladder);
    }
}
