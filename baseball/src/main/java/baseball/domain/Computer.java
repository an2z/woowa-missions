package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countSameNumber(Player player) {
        return (int) numbers.stream()
                .filter(player::contains)
                .count();
    }

    public int countSamePlace(Player player) {
        int count = 0;
        for (int place = 0; place < numbers.size(); place++) {
            if (player.isSamePlace(place, numbers.get(place))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(numbers, computer.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
