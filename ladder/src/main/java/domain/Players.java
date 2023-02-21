package domain;

import java.util.Collections;
import java.util.List;

public class Players {
    private static final int MIN_SIZE = 2;
    public static final String SIZE_ERROR = String.format("최소 %s명 이상의 사람이 참여해야 합니다.", MIN_SIZE);

    private final List<Player> players;

    public Players(List<Player> players) {
        validateSize(players.size());
        this.players = players;
    }

    public int getSize() {
        return players.size();
    }

    public int getMaxNameLength() {
        return players.stream()
                .map(Player::getNameLength)
                .reduce(Integer::max)
                .orElseThrow();
    }

    public int getFirstNameLength() {
        return players.stream()
                .findFirst()
                .map(Player::getNameLength)
                .orElseThrow();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }
}
