package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FunctionTest {

    @DisplayName("존재하지 않는 기능일 경우 예외 발생 확인")
    @CsvSource({"4", "5", "6", "A", "q"})
    @ParameterizedTest
    void makeFunctionByWrongSign(String sign) {
        assertThatThrownBy(() -> Function.getBySign(sign))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("주어진 문자열에 해당하는 기능이 선택되는지 확인")
    @CsvSource({
            "1, MATCHING",
            "2, FIND",
            "3, INIT",
            "Q, QUIT"
    })
    @ParameterizedTest
    void makeFunctionBySign(String sign, Function expected) {
        Function actual = Function.getBySign(sign);
        assertThat(actual).isEqualTo(expected);
    }
}
