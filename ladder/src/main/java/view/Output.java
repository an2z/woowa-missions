package view;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import domain.Ladder;
import domain.Line;
import domain.Player;
import domain.Players;
import domain.Status;
import java.util.List;

public class Output {
    private static final String START = "참여할 사람 이름을 입력하세요. (이름을 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    public static final String RESULT = "\n실행결과";
    public static final String BLANK = " ";
    public static final String LADDER_VERTICAL_SHAPE = "|";

    public static void printStartMessage() {
        System.out.println(START);
    }

    public static void printLadderHeightMessage() {
        System.out.println(LADDER_HEIGHT);
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
        String names = players.getPlayers().stream()
                .map(Player::getName)
                .collect(joining(BLANK + BLANK));
        System.out.println(names);
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
