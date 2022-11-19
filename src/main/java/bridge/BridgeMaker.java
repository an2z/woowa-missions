package bridge;

import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int ZERO = 0;
    private static final String UP = "U";
    private static final String DOWN = "D";

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param shapes 만들 다리의 모양
     * @return 다리
     */
    public Bridge makeBridge(List<String> shapes) {
        return new Bridge(shapes);
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();

        while (bridge.size() < size) {
            bridge.add(generateBridgeShape());
        }

        return bridge;
    }

    private String generateBridgeShape() {
        if (bridgeNumberGenerator.generate() == ZERO) {
            return DOWN;
        }
        return UP;
    }
}
