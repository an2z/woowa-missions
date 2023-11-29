package pairmatching.view;

import pairmatching.domain.Pair;

import java.util.List;

public class Output {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printPairMatchingResult(List<Pair> pairs) {
        System.out.println(LINE_SEPARATOR + "페어 매칭 결과입니다.");
        pairs.stream()
                .map(pair -> String.join(" : ", pair.getCrewNames()))
                .forEach(System.out::println);
    }
}
