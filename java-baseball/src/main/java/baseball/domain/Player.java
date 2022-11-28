package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Player {

    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(numbers, player.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
