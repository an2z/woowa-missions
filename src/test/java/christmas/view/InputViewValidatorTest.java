package christmas.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewValidatorTest {
    InputViewValidator validator = new InputViewValidator();

    @DisplayName("입력된 값이 숫자가 아니거나 공백이 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"a", "!", "1 a", "1 2", "1 "})
    @ParameterizedTest
    void validateDigit(String input) {
        assertThatThrownBy(() -> validator.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
