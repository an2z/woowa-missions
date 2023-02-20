package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanMakerTest {
    private BooleanMaker booleanMaker = new BooleanMaker();

    @Test
    @DisplayName("마지막 가로 라인이 연결 상태일 경우 false를 반환한다.")
    void makeFalse() {
        Boolean result = booleanMaker.makeBoolean(Status.CONNECTED);
        assertThat(result).isFalse();
    }
}
