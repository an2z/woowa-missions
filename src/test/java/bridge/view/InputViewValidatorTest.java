package bridge.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewValidatorTest {

    private final InputViewValidator validator = new InputViewValidator();

    @DisplayName("게임 명령 입력이 R 또는 Q가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"r", "q", "a", "b", "A", "B", "RR", "QQ"})
    @ParameterizedTest
    void makeWrongCommand(String command) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.checkCommand(command));
    }

    @DisplayName("이동할 칸 입력이 U 또는 D이 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"u", "d", "a", "b", "A", "B", "UU", "DD"})
    @ParameterizedTest
    void makeWrongMoving(String moving) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.checkCommand(moving));
    }
}
