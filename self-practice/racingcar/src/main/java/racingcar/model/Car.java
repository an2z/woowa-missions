package racingcar.model;

import java.util.Objects;

public class Car {
    private final String name;
    private int movement;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    public void move() {
        movement++;
    }

    public boolean isMaxMovement(int maxMovement) {
        return this.movement == maxMovement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
