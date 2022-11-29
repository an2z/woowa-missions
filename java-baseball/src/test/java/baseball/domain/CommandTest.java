package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommandTest {

    @DisplayName("1 또는 2가 아니면 예외 발생 확인")
    @CsvSource({"0", "3", "4", "5", "a", "가"})
    @ParameterizedTest
    void makeWrongCommand(String status) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Command(status));
    }
}
