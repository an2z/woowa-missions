package pairmatching.service;

import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Mission;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairMatchingServiceTest {

    PairMatchingService service = new PairMatchingService();

    @Test
    void reset() {
        // given
        MatchInfo matchInfo = new MatchInfo(Course.BACKEND, Level.LEVEL1, Mission.LOTTO);
        service.match(matchInfo);

        // when
        service.reset();

        // then
        assertThatThrownBy(() -> service.lookUp(matchInfo))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
