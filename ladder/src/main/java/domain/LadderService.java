package domain;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class LadderService {
    private Players players;

    public Ladder makeLadder(int inputHeight) {
        int width = players.getSize() - 1;
        int height = makeHeight(inputHeight).getHeight();
        return new Ladder(width, height);
    }

    private Height makeHeight(int inputHeight) {
        return new Height(inputHeight);
    }

    public Players makePlayers(List<String> names) {
        players = new Players(makePlayer(names));
        return players;
    }

    private List<Player> makePlayer(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(toList());
    }
}
