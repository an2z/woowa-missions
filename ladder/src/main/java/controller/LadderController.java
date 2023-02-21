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
        Players players = repeatMakePlayers();

        Output.printLadderHeightMessage();
        repeatMakeHeight();

        Ladder ladder = ladderService.makeLadder();
        Output.printResult(players, ladder);
    }

    private Players repeatMakePlayers() {
        try {
            return ladderService.makePlayers(Input.readNames());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return repeatMakePlayers();
        }
    }

    private void repeatMakeHeight() {
        try {
            ladderService.makeHeight(Input.readLadderHeight());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            repeatMakeHeight();
        }
    }
}
