package pairmatching.view;

import pairmatching.model.Pair;

import java.util.List;

public class Output {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printMatchingResult(List<Pair> pairs) {
        System.out.println(LINE_SEPARATOR + "페어 매칭 결과입니다.");
        pairs.stream()
                .map(Pair::getCrewNames)
                .map(this::joiningNames)
                .forEach(System.out::println);
    }

    private String joiningNames(List<String> names) {
        return String.join(" : ", names);
    }
}
