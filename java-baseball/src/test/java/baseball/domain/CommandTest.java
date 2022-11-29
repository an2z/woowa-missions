package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("VO 동등 비교 확인")
    @CsvSource({"1", "2"})
    @ParameterizedTest
    void checkValueObject(String status) {
        Command command1 = new Command(status);
        Command command2 = new Command(status);
        assertThat(command1).isEqualTo(command2);
        assertThat(command1).hasSameHashCodeAs(command2);
    }
}
