package domain;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public List<String> getAllNames() {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }

    public String getFirstName() {
        return players.get(0).getName();
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
