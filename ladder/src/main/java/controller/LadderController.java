package controller;

import static java.util.stream.Collectors.toList;

import domain.LadderHeight;
import domain.Player;
import domain.Players;
import java.util.List;
import view.Input;
import view.Output;

public class LadderController {
    public void run() {
        Output.printStartMessage();
        List<String> names = Input.readNames();
        Players players = new Players(makePlayer(names));

        Output.printLadderHeightMessage();
        LadderHeight ladderHeight = new LadderHeight(Input.readLadderHeight());
    }

    private static List<Player> makePlayer(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(toList());
    }
}
