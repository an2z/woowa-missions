package domain;

import java.util.Objects;

public class Player {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR = String.format("이름은 %s~%s글자만 가능합니다.", MIN_LENGTH, MAX_LENGTH);
    private final String name;

    public Player(String name) {
        name = name.trim();
        validate(name);
        this.name = name;
    }

    public int getNameLength() {
        return name.length();
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (isNotValidLength(name.length())) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private static boolean isNotValidLength(int length) {
        return length < MIN_LENGTH || MAX_LENGTH < length;
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
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
