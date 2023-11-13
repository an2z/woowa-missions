package christmas.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewValidatorTest {
    InputViewValidator validator = new InputViewValidator();

    @DisplayName("입력된 값이 빈값일 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateEmpty(String input) {
        assertThatThrownBy(() -> validator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 숫자가 아니거나 공백이 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"a", "!", "1 a", "1 2", "1 "})
    @ParameterizedTest
    void validateDigit(String input) {
        assertThatThrownBy(() -> validator.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 한글, 숫자, 구분자(-,)가 아니거나 공백이 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"해산물파스타>2", "해산물 파스타-1", "pasta-2", "파스타-1/음료-2"})
    @ParameterizedTest
    void validateOrderInfo(String input) {
        assertThatThrownBy(() -> validator.validateOrderInfo(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
