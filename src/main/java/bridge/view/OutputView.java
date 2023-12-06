package bridge.view;

import bridge.domain.BridgeGameMap;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다." + LINE_SEPARATOR);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameMap bridgeGameMap) {
        System.out.println(makeBridgeOutputShape(bridgeGameMap.getUpBridgeMap()));
        System.out.println(makeBridgeOutputShape(bridgeGameMap.getDownBridgeMap()));
    }

    private String makeBridgeOutputShape(List<Optional<Boolean>> map) {
        StringJoiner result = new StringJoiner(" | ", "[ ", " ]");

        for (Optional<Boolean> status : map) {
            result.add(status.map(this::convertToSymbol).orElse(" "));
        }
        return result.toString();
    }

    private String convertToSymbol(boolean status) {
        if (status) {
            return "O";
        }
        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameMap bridgeGameMap, boolean gameResult, int tryCount) {
        System.out.println(LINE_SEPARATOR + "최종 게임 결과");
        printMap(bridgeGameMap);
        System.out.println(LINE_SEPARATOR + "게임 성공 여부: " + makeGameResultOutput(gameResult));
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    private String makeGameResultOutput(boolean gameResult) {
        if (gameResult) {
            return "성공";
        }
        return "실패";
    }
}
