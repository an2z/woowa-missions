package controller;

import static java.util.stream.Collectors.toList;

import domain.Player;
import java.util.List;
import view.Input;
import view.Output;

public class LadderController {
    public void run() {
        Output.printStartMessage();
        List<String> names = Input.readNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(toList());
    }
}
