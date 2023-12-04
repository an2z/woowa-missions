package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String MOVEMENT = "-";

    public void showError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void showRacingResult() {
        System.out.println(LINE_SEPARATOR + "실행 결과");
    }

    public void showRacingStatus(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();
        cars.stream()
                .map(car -> format("%s : %s", car.getName(), MOVEMENT.repeat(car.getMovement())))
                .forEach(System.out::println);
        System.out.print(LINE_SEPARATOR);
    }

    public void showWinner(List<Car> winner) {
        String winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerName);
    }

    private String format(String format, Object... args) {
        return String.format(format, args);
    }
}
