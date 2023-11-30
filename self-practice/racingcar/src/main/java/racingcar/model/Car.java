package racingcar.model;

import java.util.Objects;

public class Car {
    private final String name;
    private int movement;

    public Car(String name) {
        this.name = name;
    }

    public void move(int condition) {
        if (condition >= 4) {
            movement++;
        }
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
