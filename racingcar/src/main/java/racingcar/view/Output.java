package racingcar.view;

import static java.util.stream.Collectors.joining;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Output {
    private static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "\n실행결과";
    private static final String WINNER = "최종 우승자 : ";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printCarNames() {
        System.out.println(CAR_NAMES);
    }

    public static void printRacingCount() {
        System.out.println(RACING_COUNT);
    }

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printRacingResult(Cars movedCars) {
        movedCars.getCars().stream()
                .forEach(System.out::println);

        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        String names = winner.stream()
                .map(Car::getName)
                .collect(joining(", "));

        System.out.println(WINNER + names);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    private Output() {
    }
}
