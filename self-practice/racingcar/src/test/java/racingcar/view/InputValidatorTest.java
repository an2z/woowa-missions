package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @DisplayName("빈값 또는 공백을 입력할 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  "})
    @ParameterizedTest
    void validateBlank(String input) {
        assertThatThrownBy(() -> InputValidator.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자와 쉼표가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {
            "pobi, jun",
            "pobi1,jun2",
            "pobi!,jun."
    })
    @ParameterizedTest
    void validateCarNames(String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이상의 숫자가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = {"0", "ㄱ", "s", "!"})
    @ParameterizedTest
    void validateNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
