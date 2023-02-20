package domain;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanMakerTest {
    private BooleanMaker booleanMaker = new BooleanMaker();

    @Test
    @DisplayName("이전 상태가 true인 경우 false를 반환한다.")
    void makeFalse() {
        Boolean result = booleanMaker.makeBoolean(TRUE);
        assertThat(result).isFalse();
    }
}
