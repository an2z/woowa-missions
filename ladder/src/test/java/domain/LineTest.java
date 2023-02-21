package domain;

import static domain.Status.CONNECTED;
import static domain.Status.UNCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("랜덤 값이 true면 가로 라인을 연결하고, false면 가로 라인을 연결하지 않는다.")
    void makeLineStatus() {
        Line line = new Line(Arrays.asList(true, false, true));
        assertThat(line.getPoints()).containsExactly(CONNECTED, UNCONNECTED, CONNECTED);
    }

    @Test
    @DisplayName("사다리 가로 라인이 겹쳐서 생성되지 않는다.")
    void nonOverlappingLine() {
        Line line = new Line(Arrays.asList(true, true, true, false));
        assertThat(line.getPoints()).containsExactly(CONNECTED, UNCONNECTED, CONNECTED, UNCONNECTED);
    }
}
