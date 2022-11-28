package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    NumbersGenerator generator = new RandomNumbersGenerator();

    @DisplayName("컴퓨터 수로 3자리 숫자가 생성된다.")
    @Test
    void makeComputer() {
        List<Integer> numbers = generator.makeComputer();
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }
}
