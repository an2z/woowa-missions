package pairmatching.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MissionTest {

    @DisplayName("존재하지 않는 미션일 경우 예외 발생 확인")
    @CsvSource({
            "경주자동차", "또로", "숫자게임",
            "바구니", "결자", "버스노선도",
            "성능", "배보"
    })
    @ParameterizedTest
    void makeMissionByWrongName(String name) {
        assertThatThrownBy(() -> Mission.find(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("주어진 이름에 해당하는 미션이 선택되는지 확인")
    @CsvSource({
            "자동차경주, RACING",
            "로또, LOTTO",
            "숫자야구게임, BASEBALL",
            "장바구니, BASKET",
            "결제, PAYMENT",
            "지하철노선도, SUBWAY",
            "성능개선, PERFORMANCE",
            "배포, DISTRIBUTION"
    })
    @ParameterizedTest
    void makeMission(String name, Mission expected) {
        Mission actual = Mission.find(name);
        assertThat(actual).isEqualTo(expected);
    }
}
