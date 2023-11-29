package pairmatching.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewStoreTest {
    CrewStore crewStore = new CrewStore();

    @DisplayName("과정별 크루 목록을 가져온다.")
    @Test
    void findAllByCourse() {
        List<String> backendCrews = crewStore.findAllByCourse(Course.BACKEND);
        List<String> frontendCrews = crewStore.findAllByCourse(Course.FRONTEND);
        assertThat(backendCrews).hasSize(20);
        assertThat(frontendCrews).hasSize(15);
    }
}
