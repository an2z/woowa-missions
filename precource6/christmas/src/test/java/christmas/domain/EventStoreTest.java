package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EventStoreTest {
    EventStore eventStore = new EventStore();

    @DisplayName("방문 날짜에 진행 중인 이벤트를 조회한다.")
    @CsvSource({"1, 4", "25, 4", "26, 3"})
    @ParameterizedTest
    void findOngoingEvents(int day, int expected) {
        LocalDate visitDate = LocalDate.of(2023, 12, day);
        List<Event> ongoingEvents = eventStore.findOngoingEvents(visitDate);
        assertThat(ongoingEvents).hasSize(expected);
    }
}
