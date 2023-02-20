package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HeightTest {
    @ParameterizedTest
    @CsvSource({"0", "-1", "-2"})
    @DisplayName("사다리 높이가 1개 미만일 경우 예외가 발생한다.")
    void validateMinHeight(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("VO 동등 비교를 확인한다.")
    void checkVO() {
        Height height1 = new Height(1);
        Height height2 = new Height(1);

        assertThat(height1).isEqualTo(height2);
        assertThat(height1).hasSameHashCodeAs(height2);
    }
}
