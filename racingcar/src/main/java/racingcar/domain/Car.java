package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 %d ~ %d글자만 가능합니다.";

    private final String name;
    private int position = 0;

    public Car(String name) {
        name = name.trim();
        validateNameLength(name);
        this.name = name;
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(NAME_LENGTH_ERROR_MESSAGE, MIN_NAME_LENGTH, MAX_NAME_LENGTH));
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
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
