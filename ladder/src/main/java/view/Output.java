package view;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import domain.Ladder;
import domain.Line;
import domain.Players;
import domain.Status;
import java.util.List;

public class Output {
    private static final String START = "참여할 사람 이름을 입력하세요. (이름을 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String RESULT = "\n실행결과";
    public static final String BLANK = " ";
    public static final String LADDER_VERTICAL_SHAPE = "|";
    private static final String NAME_FORMAT = " %%%ds";

    public static void printStartMessage() {
        System.out.println(START);
    }

    public static void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printResult(Players players, Ladder ladder) {
        printResultMessage();
        printPlayers(players);
        printLadder(players.getFirstNameLength(), players.getMaxNameLength(), ladder);
    }

    private static void printResultMessage() {
        System.out.println(RESULT);
    }

    private static void printPlayers(Players players) {
        System.out.println(players.getFirstName() + makeNamesFormat(players));
    }

    private static String makeNamesFormat(Players players) {
        return players.getAllNames().stream()
                .skip(1L)
                .map(name -> convertToPrintFormat(name, players.getMaxNameLength()))
                .collect(joining());
    }

    private static String convertToPrintFormat(String name, int width) {
        String nameFormat = String.format(NAME_FORMAT, width);
        return String.format(nameFormat, name);
    }

    private static void printLadder(int fistNameLength, int width, Ladder ladder) {
        List<List<Status>> result = ladder.getLines().stream()
                .map(Line::getPoints)
                .collect(toList());

        for (List<Status> statuses : result) {
            System.out.print(BLANK.repeat(fistNameLength - 1));
            System.out.println(LADDER_VERTICAL_SHAPE + makeLadderShape(width, statuses) + LADDER_VERTICAL_SHAPE);
        }
    }

    private static String makeLadderShape(int width, List<Status> statuses) {
        return statuses.stream()
                .map(Status::getShape)
                .map(shape -> shape.repeat(width))
                .collect(joining(LADDER_VERTICAL_SHAPE));
    }

    private Output() {
    }
}
