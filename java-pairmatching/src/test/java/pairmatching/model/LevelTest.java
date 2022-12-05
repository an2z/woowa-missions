package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("주어진 이름에 해당하는 레벨이 선택되는지 확인")
    @CsvSource({
            "레벨1, LEVEL1",
            "레벨2, LEVEL2",
            "레벨3, LEVEL3",
            "레벨4, LEVEL4",
            "레벨5, LEVEL5"
    })
    @ParameterizedTest
    void makeLevelByNameAndMission(String name, Level expected) {
        Level actual = Level.getByName(name);
        assertThat(actual).isEqualTo(expected);
    }
}
