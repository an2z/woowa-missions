package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderHeightTest {
    @ParameterizedTest
    @CsvSource({"0", "-1", "-2"})
    @DisplayName("사다리 높이가 1개 미만일 경우 예외가 발생한다.")
    void validateMinHeight(int height) {
        assertThatThrownBy(() -> new LadderHeight(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
