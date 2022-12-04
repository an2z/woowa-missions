package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LevelTest {

    @DisplayName("존재하지 않는 레벨일 경우 예외 발생 확인")
    @CsvSource({"레벨6", "레벨7", "레벨8", "레벨"})
    @ParameterizedTest
    void makeLevelByWrongName(String name) {
        assertThatThrownBy(() -> Level.getByName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
