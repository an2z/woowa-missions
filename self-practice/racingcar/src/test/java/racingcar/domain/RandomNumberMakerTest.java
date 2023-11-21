package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberMakerTest {
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4"})
    @DisplayName("원하는 크기만큼 랜덤 숫자가 생성된다.")
    void makeRandomNumbers(int size) {
        List<Integer> result = RandomNumberMaker.makeRandomNumbers(size);
        assertThat(result).hasSize(size);
    }
}
