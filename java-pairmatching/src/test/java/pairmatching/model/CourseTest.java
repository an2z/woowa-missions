package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CourseTest {

    @DisplayName("존재하지 않는 과정일 경우 예외 발생 확인")
    @CsvSource({"프엔", "백엔", "안드로이드", "인프라"})
    @ParameterizedTest
    void makeLevelByWrongName(String type) {
        assertThatThrownBy(() -> Course.getByType(type))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("주어진 타입에 해당하는 과정이 선택되는지 확인")
    @CsvSource({"백엔드, BACKEND", "프론트엔드, FRONTEND",})
    @ParameterizedTest
    void makeLevelByNameAndMission(String type, Course expected) {
        Course actual = Course.getByType(type);
        assertThat(actual).isEqualTo(expected);
    }
}
