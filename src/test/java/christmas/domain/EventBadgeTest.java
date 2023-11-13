package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {
    @DisplayName("총 혜택 금액에 해당하는 이벤트 배지를 확인한다.")
    @CsvSource({
            "0, NONE",
            "4999, NONE",
            "5000, STAR",
            "9999, STAR",
            "10000, TREE",
            "19999, TREE",
            "20000, SANTA",
    })
    @ParameterizedTest
    void findBadge(int totalBenefit, EventBadge expected) {
        EventBadge eventBadge = EventBadge.find(totalBenefit);
        assertThat(eventBadge).isEqualTo(expected);
    }
}
